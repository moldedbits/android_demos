package com.moldedbits.androiddemos;

import android.app.Application;

import com.moldedbits.androiddemos.library_demos.timber.CrashlyticsTree;
import com.moldedbits.androiddemos.library_demos.timber.LineNoDebugTree;

import timber.log.Timber;

/**
 * Main application class
 * Should be used for app wide initializations
 * Created by abhishek on 28/12/15.
 */
public class AndroidDemosApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // This makes sure that logs are only generated in debug mode
        // even when proguard is not in action
        if(BuildConfig.DEBUG) {
            // DebugTree has all usual logging functionality
            Timber.plant(new Timber.DebugTree());
        }
        // planting another tree in parallel to existing Debug Tree
        // this can send crash/exception reports to Crashlytics alongside existing logging/crash
        // reporting mechanism. This can also be done conditionally for release builds only.
        Timber.plant(new CrashlyticsTree());

        Timber.plant(new LineNoDebugTree());
    }
}
