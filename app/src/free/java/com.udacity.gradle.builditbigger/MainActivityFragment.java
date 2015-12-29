package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import app.com.example.ttins.androidjokelib.JokeLibMainActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public static final String INTENT_JOKE = "JOKE";
    private ProgressBar mSpinner;
    InterstitialAd mInterstitialAd;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        Button mTellJokeButton = (Button) root.findViewById(R.id.tell_joke_button);
        mSpinner = (ProgressBar) root.findViewById(R.id.progressBar);
        mSpinner.setVisibility(View.GONE);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(getString(R.string.banner_ad_unit_id));
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                tellJoke();
            }
        });

        requestNewInterstitial();

        mTellJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    tellJoke();
                }
            }
        });


        return root;
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    public void tellJoke(){

        AsyncFileDownloader asyncFileDownloader;
        DownloadHolder downloadHolder;

        mSpinner.setVisibility(View.VISIBLE);
        downloadHolder = new DownloadHolder();
        asyncFileDownloader = new AsyncFileDownloader(getActivity(), downloadHolder);
        asyncFileDownloader.download();

    }


    class DownloadHolder implements IDownloadListener {

        public void downloadComplete(Context context, String result) {
            Intent intent = new Intent(context, JokeLibMainActivity.class);
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(INTENT_JOKE, result);
            mSpinner.setVisibility(View.GONE);
            startActivity(intent);
        }
    }
}
