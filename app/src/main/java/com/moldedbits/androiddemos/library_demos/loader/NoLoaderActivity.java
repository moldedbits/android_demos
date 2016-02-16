package com.moldedbits.androiddemos.library_demos.loader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.moldedbits.androiddemos.R;
import com.moldedbits.androiddemos.library_demos.loader.api.ApiProvider;
import com.moldedbits.androiddemos.library_demos.loader.model.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NoLoaderActivity extends AppCompatActivity implements
        Callback<Example> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader_main);

        populateExample();
    }

    private void populateExample() {
        ApiProvider.getService().getExample().enqueue(this);
    }

    public void refresh(View view) {
        ((TextView) findViewById(R.id.text)).setText(getString(R.string.app_name));
        populateExample();
    }

    @Override
    public void onResponse(Call<Example> call, Response<Example> response) {
        ((TextView) findViewById(R.id.text)).setText(response.body().toString());
    }

    @Override
    public void onFailure(Call<Example> call, Throwable t) {

    }
}
