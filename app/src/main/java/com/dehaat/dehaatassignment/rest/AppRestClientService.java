package com.dehaat.dehaatassignment.rest;

import com.dehaat.dehaatassignment.model.Data;
import com.dehaat.dehaatassignment.model.UserAuthDetails;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AppRestClientService {

    @FormUrlEncoded
    @POST("/dehaat/login")
    Call<UserAuthDetails> login(
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("/dehaat/authors")
    Call<Data> getListOfAuthors();

}
