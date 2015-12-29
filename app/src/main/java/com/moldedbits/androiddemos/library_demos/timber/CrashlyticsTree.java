package com.moldedbits.androiddemos.library_demos.timber;

import android.support.annotation.Nullable;
import android.util.Log;

import timber.log.Timber;

/**
 * An additional tree for Timber for usage with Crashlytics
 * This will log any exceptions and errors with Crashlytics for inspection
 * Created by abhishek on 28/12/15.
 */
public class CrashlyticsTree extends Timber.Tree {
    private static final String CRASHLYTICS_KEY_PRIORITY = "priority";
    private static final String CRASHLYTICS_KEY_TAG = "tag";
    private static final String CRASHLYTICS_KEY_MESSAGE = "message";

    @Override
    protected void log(int priority, @Nullable String tag, @Nullable String message, @Nullable Throwable t) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
            return;
        }

//        Crashlytics.setInt(CRASHLYTICS_KEY_PRIORITY, priority);
//        Crashlytics.setString(CRASHLYTICS_KEY_TAG, tag);
//        Crashlytics.setString(CRASHLYTICS_KEY_MESSAGE, message);
//
        if (t == null) {
            Log.e("CRASHLYTICS", message);
//            Crashlytics.logException(new Exception(message));
        } else {
            Log.e("CRASHLYTICS", message);
//            Crashlytics.logException(t);
        }
    }
}
