package com.gfa.springadvanced.services.retrofitServices;

import com.gfa.springadvanced.models.DTOs.MoviesDTO;
import com.gfa.springadvanced.models.DTOs.ResultDTO;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

import java.util.List;


public interface ApiRetrofitServices {


        @GET("search/movie")
        Call<ResultDTO> listMovies(@Query("api_key") String apiKey, @Query("query") String query);


}
