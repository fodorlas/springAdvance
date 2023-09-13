package com.gfa.springadvanced.models;

import com.gfa.springadvanced.models.DTOs.MoviesDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    private Long movieId;

    private String originalLanguage;

    private String originalTitle;
    @Column(columnDefinition = "TEXT")
//    @Column(length = 1000)
    private String overview;

    private String title;

    private String genreId;


    public Movie() {
    }

    public Movie(MoviesDTO moviesDTO) {
        this.movieId = moviesDTO.getId();
        this.originalLanguage = moviesDTO.getOriginalLanguage();
        this.originalTitle = moviesDTO.getOriginalTitle();
        this.overview = moviesDTO.getOverview();
        this.title = moviesDTO.getTitle();
        StringBuilder sb = new StringBuilder();
        for ( Integer id : moviesDTO.getGenreId() ) {
            sb.append(id).append(" ");
        }
        this.genreId = sb.toString();
    }

    public Movie(Long movieId, String originalLanguage, String originalTitle, String overview, String title, List<Integer> genreId) {
        this.movieId = movieId;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.title = title;
        StringBuilder sb = new StringBuilder();
        for ( Integer id : genreId ) {
            sb.append(id).append(" ");
        }
        this.genreId = sb.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
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

    public String getGenreId() {
        return genreId;
    }

    public void setGenreId(List<Integer> genreId) {
        StringBuilder sb = new StringBuilder();
        for ( Integer id : genreId ) {
            sb.append(id).append(" ");
        }
        this.genreId = sb.toString();
    }
}
