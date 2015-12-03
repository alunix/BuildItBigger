package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

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

    public void testMainActivityExists() {
        MainActivity mainActivity = getActivity();
        assertNotNull(mainActivity);
    }

    public void testAsyncTaskDownload() throws InterruptedException {
        //MainActivity mainActivity = getActivity();
        //assertNotNull(mainActivity);

        asyncFileDownloader.download();
        assertTrue("Can't retrieve information from back end service", countDownLatch.await(30, TimeUnit.SECONDS));

    }

    public void downloadComplete(Context context, String result) {
        countDownLatch.countDown();
        assertNotNull("String received from back end service is null", result);
        assertTrue("String received from back end service is empty", !result.equals(""));
    }

}
