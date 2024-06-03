package com.example.spring_cinema_api.repositories;

import com.example.spring_cinema_api.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
