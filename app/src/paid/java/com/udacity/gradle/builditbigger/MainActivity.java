package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import app.com.example.ttins.androidjokelib.JokeLibMainActivity;


public class MainActivity extends ActionBarActivity {

    public static final String INTENT_JOKE = "JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){

        AsyncFileDownloader asyncFileDownloader;
        DownloadHolder downloadHolder;

        downloadHolder = new DownloadHolder();
        asyncFileDownloader = new AsyncFileDownloader(this, downloadHolder);
        asyncFileDownloader.download();

    }


    class DownloadHolder implements IDownloadListener {

        public void downloadComplete(Context context, String result) {
            Intent intent = new Intent(context, JokeLibMainActivity.class);
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(INTENT_JOKE, result);
            startActivity(intent);
        }
    }

}
