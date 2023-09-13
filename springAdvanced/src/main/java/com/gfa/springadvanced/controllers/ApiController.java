package com.gfa.springadvanced.controllers;


import com.gfa.springadvanced.models.DTOs.MoviesDTO;
import com.gfa.springadvanced.services.UserService;
import com.gfa.springadvanced.services.retrofitServices.ApiRetrofitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class ApiController {

    private final UserService userService;
    private final ApiRetrofitServices apiRetrofitServices;

    @Autowired
    public ApiController(UserService userService, ApiRetrofitServices apiRetrofitServices) {
        this.userService = userService;
        this.apiRetrofitServices = apiRetrofitServices;
    }

    @GetMapping("/movies")
    public ResponseEntity<?> listMovies(){
        Call<List<MoviesDTO>> call = apiRetrofitServices.listMovies(query);
        Response<List<MoviesDTO>> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<MoviesDTO> movies = response.body();
        return ResponseEntity.ok(movies);
    }

}
