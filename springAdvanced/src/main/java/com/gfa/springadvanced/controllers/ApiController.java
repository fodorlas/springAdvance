package com.gfa.springadvanced.controllers;


import com.gfa.springadvanced.models.DTOs.MoviesDTO;
import com.gfa.springadvanced.models.DTOs.ResultDTO;
import com.gfa.springadvanced.services.MovieServices;
import com.gfa.springadvanced.services.UserService;
import com.gfa.springadvanced.services.retrofitServices.ApiRetrofitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
public class ApiController {

    private final UserService userService;
    private final ApiRetrofitServices apiRetrofitServices;
    private final MovieServices movieServices;
    private final String apiKey = "e0a94ad12e5bb18854f2b7245907b48a";

    @Autowired
    public ApiController(UserService userService, ApiRetrofitServices apiRetrofitServices, MovieServices movieServices) {
        this.userService = userService;
        this.apiRetrofitServices = apiRetrofitServices;
        this.movieServices = movieServices;
    }
        @GetMapping("/movies")
        public ResponseEntity<?> listMovies(@RequestParam Optional<String> optionalTitle) {
        if (optionalTitle.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        String title = optionalTitle.get();

        return movieServices.getMoviesByName(title);

        }

    @GetMapping("/movies/findall")
    public ResponseEntity<?> listMoviesFromDb() {


        return movieServices.getAllMoviesFromDB4();

    }
}


