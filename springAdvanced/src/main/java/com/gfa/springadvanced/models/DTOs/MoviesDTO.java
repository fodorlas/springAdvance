package com.gfa.springadvanced.models.DTOs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

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
    private List<Integer> genreId;

    public MoviesDTO() {
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
