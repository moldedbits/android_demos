package com.moldedbits.androiddemos.sromku_facebook_integration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.moldedbits.androiddemos.R;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sromku);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView ivProfile = (ImageView) findViewById(R.id.imv_profile);
        TextView tvName = (TextView) findViewById(R.id.tv_name);
        TextView tvEmail = (TextView) findViewById(R.id.tv_email);

        Glide.with(this).load(FacebookLoginActivity.profilePic)
                .into(ivProfile);
        tvName.setText(FacebookLoginActivity.profileName);
        tvEmail.setText(FacebookLoginActivity.profileemail);

    }

}
