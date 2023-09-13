package com.gfa.springadvanced.models.DTOs;

import com.gfa.springadvanced.models.Movie;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MoviesDTO {

    @SerializedName("id")
    private Long movieId;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("original_title")
    private String originalTitle;
    private String overview;
    private String title;
    @SerializedName("genre_ids")
    private List<Integer> genreId = new ArrayList<>();

    public MoviesDTO() {
    }

    public MoviesDTO( Movie movie) {
        this.movieId = movie.getMovieId();
        this.originalLanguage = movie.getOriginalLanguage();
        this.originalTitle = movie.getOriginalTitle();
        this.overview = movie.getOverview();
        this.title = movie.getTitle();
//  Solution 1
        if ( !movie.getGenreId().isEmpty()) {
            this.genreId = Arrays.stream(movie.getGenreId().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
//  Solution 2
//        if ( !movie.getGenreId().isEmpty()) {
//            String[] genreIds;
//            genreIds = movie.getGenreId().split(" ");
//            for ( String string : genreIds ) {
//                this.genreId.add(Integer.parseInt(string));
//            }
//        }

    }

    public MoviesDTO(Long movieId, String originalLanguage, String originalTitle, String overview, String title, List<Integer> genreId) {
        this.movieId = movieId;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.title = title;
        this.genreId = genreId;
    }

    public Long getId() {
        return movieId;
    }

    public void setId(Long movieId) {
        this.movieId = movieId;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Integer> getGenreId() {
        return genreId;
    }

    public void setGenreId(List<Integer> genreId) {
        this.genreId = genreId;
    }
}
