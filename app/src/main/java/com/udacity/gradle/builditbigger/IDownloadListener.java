package com.udacity.gradle.builditbigger;


import android.content.Context;

public interface IDownloadListener {
    void downloadComplete(Context context, String result);
}
