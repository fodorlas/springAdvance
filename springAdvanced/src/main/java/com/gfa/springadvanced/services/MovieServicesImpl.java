package com.gfa.springadvanced.services;

import com.gfa.springadvanced.models.DTOs.MoviesDTO;
import com.gfa.springadvanced.models.DTOs.ResultDTO;
import com.gfa.springadvanced.models.Movie;
import com.gfa.springadvanced.repositories.MovieRepository;
import com.gfa.springadvanced.services.retrofitServices.ApiRetrofitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServicesImpl implements MovieServices {

    private final MovieRepository movieRepository;
    private final UserService userService;
    private final ApiRetrofitServices apiRetrofitServices;
    private final String apiKey = "e0a94ad12e5bb18854f2b7245907b48a";

    @Autowired
    public MovieServicesImpl(UserService userService,
                             ApiRetrofitServices apiRetrofitServices,
                             MovieRepository movieRepository) {
        this.userService = userService;
        this.apiRetrofitServices = apiRetrofitServices;
        this.movieRepository = movieRepository;

    }

    @Override
    public ResponseEntity<?> getMoviesByName(String query) {

        if (checkMovie(query).isPresent()){
            return ResponseEntity.ok(checkMovie(query).get());
        }
        else {
            Call<ResultDTO> call = apiRetrofitServices.listMovies(apiKey, query);

            try {
                Response<ResultDTO> response = call.execute();

                if (response.isSuccessful()) {
                    List<MoviesDTO> movies = response.body().getResults();
                    for ( MoviesDTO movie : movies ) {
                        saveMovie(new Movie(movie));
                    }
                    return ResponseEntity.ok(movies);
                } else {
                    return ResponseEntity.status(response.code()).body("API request failed");
                }
            } catch (IOException e) {
                return ResponseEntity.status(500).body("Internal Server Error");
            }
        }

    }


    @Override
    public ResponseEntity<?> getMoviesByTitle(String title) {
        return null;
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Optional<Movie> checkMovie(String title) {
        return movieRepository.findByTitle(title);
    }

    @Override
    public ResponseEntity<?> getAllMoviesFromDb() {
        List<MoviesDTO> listOfMoviesDTO = new ArrayList<>();
        List<Movie> listOfMovies = movieRepository.findAll();
        if (!listOfMovies.isEmpty()) {
            for ( Movie movie : listOfMovies ) {
                listOfMoviesDTO.add(new MoviesDTO(movie));
            }
        }
        return ResponseEntity.ok(listOfMoviesDTO);

    }

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
    @Override
    public ResponseEntity<List<MoviesDTO>> getAllMoviesFromDB4() {
    List<MoviesDTO> result = movieRepository.findAll().stream()
            .map(MoviesDTO::new)
            .collect(Collectors.toList());

    return ResponseEntity.ok(result);
    }
}
