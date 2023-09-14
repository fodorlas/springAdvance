package com.gfa.springadvanced.services.retrofitServices;

import com.gfa.springadvanced.models.DTOs.ResultDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRetrofitServices {

        @GET("search/movie")
        Call<ResultDTO> listMovies(@Query("api_key") String apiKey, @Query("query") String query);

}
