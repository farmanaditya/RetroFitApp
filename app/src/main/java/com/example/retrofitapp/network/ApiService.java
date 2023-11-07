package com.example.retrofitapp.network;

import com.example.retrofitapp.model.Users;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET ("employees")
    Call<Users> getAllUsers();
}
