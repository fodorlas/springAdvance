package com.gfa.springadvanced.services;

import com.gfa.springadvanced.models.DTOs.MoviesDTO;
import com.gfa.springadvanced.models.Movie;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface MovieServices {
    ResponseEntity<?> getMoviesByName(String query);

    ResponseEntity<?> getMoviesByTitle(String title);

    Movie saveMovie(Movie movie);

    Optional<Movie> checkMovie(String title);

    ResponseEntity<?> getAllMoviesFromDb();

    //    public ResponseEntity<List<MoviesDTO>> getAllMoviesFromDB2() {
    //        List<MoviesDTO> result = movieRepository.findAll().stream()
    //                .map(o -> new MoviesDTO(
    //                        o.getMovieId(),
    //                        o.getOriginalTitle(),
    //                        o.getOriginalLanguage(),
    //                        o.getTitle(),
    //                        o.getOverview(),
    //                        o.getGenreId().)
    //                .collect(Collectors.toList());
    //    }
    //
    //    public ResponseEntity<List<MoviesDTO>> getAllMoviesFromDB3() {
    //        List<MovieDTO> result = movieRepository.findAll().stream()
    //                .map(o -> new MoviesDTO(o))
    //    }
    ResponseEntity<List<MoviesDTO>> getAllMoviesFromDB4();
}
