package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> implements IDownloadListener {

    AsyncFileDownloader asyncFileDownloader;
    CountDownLatch countDownLatch;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        countDownLatch = new CountDownLatch(1);
        asyncFileDownloader = new AsyncFileDownloader(getActivity(), this);

    }

    public void testMainActivityExists() throws InterruptedException {
        //MainActivity mainActivity = getActivity();
        //assertNotNull(mainActivity);

        asyncFileDownloader.download();
        countDownLatch.await(30, TimeUnit.SECONDS);
    }


    public void downloadComplete(Context context, String Result) {
        countDownLatch.countDown();
    }

}
