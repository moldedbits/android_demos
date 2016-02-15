package com.moldedbits.androiddemos.library_demos.timber;

import timber.log.Timber;

/**
 * One more sample tree which prints line no along with tag
 * Created by abhishek on 29/12/15.
 */
public class LineNoDebugTree extends Timber.DebugTree {
    @Override
    protected String createStackElementTag(StackTraceElement element) {
        return super.createStackElementTag(element) + ":" + element.getLineNumber();
    }
}
