package com.gfa.springadvanced.thirdpartyinterface;

import retrofit2.http.GET;

public class RetrofitAPI {

    @GET(value="/search/movie")
    Call<List<Movie>> getAllMovie();


}
