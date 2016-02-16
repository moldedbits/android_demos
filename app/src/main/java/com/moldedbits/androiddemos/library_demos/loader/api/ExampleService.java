package com.moldedbits.androiddemos.library_demos.loader.api;

import com.moldedbits.androiddemos.library_demos.loader.model.Example;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ExampleService {

    @GET("example.json")
    Call<Example> getExample();
}
