package com.gfa.springadvanced.services.retrofitServices;

import com.gfa.springadvanced.models.DTOs.MoviesDTO;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import java.util.List;

public class ApiRetrofitServicesImpl implements ApiRetrofitServices {

    private final String apiKey = "e0a94ad12e5bb18854f2b7245907b48a";


    //https://api.themoviedb.org/3/search/movie?query=deadpool
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create()) // Add a converter factory for JSON parsing
            .build();

    ApiRetrofitServices service = retrofit.create(ApiRetrofitServices.class);



    //Call<List<Repo>> repos = service.listRepos("octocat");
    @Override
    @Headers("api_key: " + apiKey)
    @GET("search/movie")
    public Call<List<MoviesDTO>> listMovies(@Query("query") String query) {
        return service.listMovies(query);
    }


}
