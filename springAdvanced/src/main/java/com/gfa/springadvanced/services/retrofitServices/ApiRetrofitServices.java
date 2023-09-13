package com.gfa.springadvanced.services.retrofitServices;

import com.gfa.springadvanced.models.DTOs.MoviesDTO;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;


public interface ApiRetrofitServices {


        @GET("search/movie")
        Call<List<MoviesDTO>> listMovies(@Query("query") String query);


}
