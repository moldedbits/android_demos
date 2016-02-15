package com.moldedbits.androiddemos.library_demos.loader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.moldedbits.androiddemos.R;

public class LoaderDemoMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader_options);
    }

    public void withoutLoader(View view) {
        Intent intent = new Intent(this, NoLoaderActivity.class);
        startActivity(intent);
    }

    public void withLoader(View view) {
        Intent intent = new Intent(this, LoaderActivity.class);
        startActivity(intent);
    }
}
