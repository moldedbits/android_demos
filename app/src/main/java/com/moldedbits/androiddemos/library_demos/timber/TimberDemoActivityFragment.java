package com.moldedbits.androiddemos.library_demos.timber;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moldedbits.androiddemos.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class TimberDemoActivityFragment extends Fragment {

    public TimberDemoActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_timber_demo, container, false);
    }
}
