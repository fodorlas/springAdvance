package com.gfa.springadvanced.repositories;

import com.gfa.springadvanced.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
