package com.gfa.springadvanced.services;

import com.gfa.springadvanced.models.Movie;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface MovieServices {
    ResponseEntity<?> getMoviesByName(String query);

    ResponseEntity<?> getMoviesByTitle(String title);

    Movie saveMovie(Movie movie);

    Optional<Movie> checkMovie(String title);
}
