package com.moldedbits.androiddemos.toolbox_demo;

import android.os.Bundle;

import com.moldedbits.android.toolbox.ui.widget.DaySelectorDialog;
import com.moldedbits.androiddemos.BaseActivity;
import com.moldedbits.androiddemos.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by shishank on 08/09/16.
 */

public class CustomWidgetActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_widget);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_picker)
    public void onClick() {
       DaySelectorDialog.newInstance().show(getFragmentManager(), null);
    }
}
