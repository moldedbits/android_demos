package com.moldedbits.androiddemos.library_demos.timber;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moldedbits.androiddemos.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class TimberDemoActivityFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_timber_demo, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.btn_log_timber)
    public void logTimber() {
        Timber.d("This is a debug log");
        Timber.e("This is a error log with formatting: %s", "DEMO ERROR");
        Timber.i(new IllegalArgumentException(), "Logging an exception with string formatting #%d", 1);

        // Lint should show following warning for above case
        // Warning: Replace String concatenation with Timber's string formatting [BinaryOperationInTimber]
        String someString = "Concatenation in timber";
        Timber.v(someString + " Lint will complain about this " + 1);

        // Using custom TAG timber by default uses filename as TAG
        Timber.tag("CustomTag").d("Debug log with custom tag");
    }
}
