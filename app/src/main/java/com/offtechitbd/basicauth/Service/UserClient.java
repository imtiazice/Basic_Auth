package com.offtechitbd.basicauth.Service;

import com.offtechitbd.basicauth.Model.User;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UserClient {

    @POST("login")
    Call<User> getUser(@Header("Authorization") String authHeader);

}
