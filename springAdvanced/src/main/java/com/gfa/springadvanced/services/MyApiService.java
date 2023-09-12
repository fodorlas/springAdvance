package com.gfa.springadvanced.services;
import com.gfa.springadvanced.models.Movie;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

@Component
public interface MyApiService {

    // Define the HTTP GET request for fetching a list of posts
    @GET("movie")
    Call<List<Movie>> getMovies();

    // Optionally, you can define additional API endpoints as needed
    @GET("movie/{id}")
    Call<Movie> getPostById(@Path("id") int postId);
}
