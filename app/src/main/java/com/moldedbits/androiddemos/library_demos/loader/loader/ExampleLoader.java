package com.moldedbits.androiddemos.library_demos.loader.loader;

import android.content.Context;
import android.support.v4.content.Loader;

import com.moldedbits.androiddemos.library_demos.loader.api.ApiProvider;
import com.moldedbits.androiddemos.library_demos.loader.model.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class ExampleLoader extends Loader<Example> implements Callback<Example> {

    private Example mExample;

    private Throwable mLastError;

    public ExampleLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        Timber.d("onStartLoading");
        if (mExample != null) {
            deliverResult(mExample);
        } else {
            getExample();
        }
    }

    @Override
    protected void onForceLoad() {
        Timber.d("onForceLoad");
        getExample();
    }

    private void getExample() {
        ApiProvider.getService().getExample().enqueue(this);
    }

    @Override
    public void onResponse(Call<Example> call, Response<Example> response) {
        mExample = response.body();
        deliverResult(response.body());
    }

    @Override
    public void onFailure(Call<Example> call, Throwable t) {
        deliverResult(null);
        mLastError = t;
    }

    public Throwable getLastError() {
        return mLastError;
    }
}
