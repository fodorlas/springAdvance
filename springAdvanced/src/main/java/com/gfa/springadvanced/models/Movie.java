package com.gfa.springadvanced.models;

import com.gfa.springadvanced.services.MyApiService;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table("movies")
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    private final MyApiService myApiService;

    public Movie(MyApiService myApiService) {
        this.myApiService = myApiService;
    }

    public Movie() {

    }
}
