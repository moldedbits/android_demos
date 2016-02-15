package com.moldedbits.checkstyledemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.Bind;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.text)
    View mTextView;

    private int incorrectName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
