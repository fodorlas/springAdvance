package com.gfa.springadvanced.services;
import com.gfa.springadvanced.models.ApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApiService {

    @GET("authentication")
    Call<ApiResponse> authenticate();

}
