package com.moldedbits.androiddemos.sromku_facebook_integration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.moldedbits.androiddemos.R;
import com.sromku.simple.fb.Permission;
import com.sromku.simple.fb.SimpleFacebook;
import com.sromku.simple.fb.SimpleFacebookConfiguration;
import com.sromku.simple.fb.entities.Profile;
import com.sromku.simple.fb.listeners.OnLoginListener;
import com.sromku.simple.fb.listeners.OnProfileListener;

import java.util.List;

public class FacebookLoginActivity extends AppCompatActivity {

    SimpleFacebook mSimpleFacebook;
    public String TAG = "FacebookLoginActivity";
    public static String profilePic = "";
    public static String profileName = "";
    public static String profileemail = "";

    Profile.Properties properties = new Profile.Properties.Builder()
            .add(Profile.Properties.ID)
            .add(Profile.Properties.FIRST_NAME)
            .add(Profile.Properties.COVER)
            .add(Profile.Properties.WORK)
            .add(Profile.Properties.EDUCATION)
            .add(Profile.Properties.PICTURE)
            .add(Profile.Properties.EMAIL)
            .add(Profile.Properties.BIRTHDAY)
            .build();

    OnLoginListener onLoginListener = new OnLoginListener() {

        @Override
        public void onLogin(String accessToken, List<Permission> acceptedPermissions, List<Permission> declinedPermissions) {
            // change the state of the button or do whatever you want
            Log.i(TAG, "Logged in");
            Log.d(TAG, "" + accessToken);
            mSimpleFacebook.getProfile(properties, onProfileListener);
        }

        @Override
        public void onCancel() {
            // user canceled the dialog
        }

        @Override
        public void onFail(String reason) {
            // failed to login
        }

        @Override
        public void onException(Throwable throwable) {
            // exception from facebook

        }
    };
    OnProfileListener onProfileListener = new OnProfileListener() {
        @Override
        public void onComplete(Profile profile) {
            Log.i(TAG, "My profile id = " + profile.getId());
            profilePic = "http://graph.facebook.com/" + profile.getId() + "/picture?type=normal";
            profileName = profile.getFirstName();
            profileemail = profile.getBirthday();

            Log.d("name", "name" + profileName);
            Log.e("mail", "mail" + profileemail);

            if (profile.getId() != null) {
                Intent intent = new Intent(getApplicationContext(), Detail.class);
                startActivity(intent);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_sample_sromku);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView tvLogin = (TextView) findViewById(R.id.tv_login);
        config();
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSimpleFacebook.login(onLoginListener);
            }
        });
    }


    public void config() {
        Permission[] permissions = new Permission[]{
                Permission.USER_PHOTOS,
                Permission.EMAIL,
                Permission.PUBLISH_ACTION
        };

        SimpleFacebookConfiguration configuration = new SimpleFacebookConfiguration.Builder()
                .setAppId("194881837524606")
                .setNamespace("Testing")
                .setPermissions(permissions)
                .build();
        SimpleFacebook.setConfiguration(configuration);
    }

    public void onResume() {
        super.onResume();
        mSimpleFacebook = SimpleFacebook.getInstance(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mSimpleFacebook.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}

