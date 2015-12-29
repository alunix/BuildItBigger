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

import app.com.example.ttins.androidjokelib.JokeLibMainActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public static final String INTENT_JOKE = "JOKE";

    private ProgressBar mSpinner;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mSpinner = (ProgressBar) rootView.findViewById(R.id.progressBar);
        Button mTellJokeButton = (Button) rootView.findViewById(R.id.tell_joke_button);

        mTellJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tellJoke();
            }
        });

        mSpinner.setVisibility(View.GONE);

        return rootView;
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
