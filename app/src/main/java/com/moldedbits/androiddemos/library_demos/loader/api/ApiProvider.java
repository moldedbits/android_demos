package com.moldedbits.androiddemos.library_demos.loader.api;

import com.moldedbits.androiddemos.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiProvider {

    private static ExampleService mExampleService;

    public static ExampleService getService() {
        if (mExampleService == null) {
            initApi();
        }

        return mExampleService;
    }

    private static void initApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mExampleService = retrofit.create(ExampleService.class);
    }
}
