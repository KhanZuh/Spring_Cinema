package com.example.spring_cinema_api.components;

import com.example.spring_cinema_api.models.Movie;
import com.example.spring_cinema_api.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Create some sample movies
        Movie movie1 = new Movie("The Shawshank Redemption", "R", 142);
        Movie movie2 = new Movie("The Godfather", "R", 175);
        Movie movie3 = new Movie("The Dark Knight", "PG-13", 152);
        Movie movie4 = new Movie("Pulp Fiction", "R", 154);
        Movie movie5 = new Movie("Forrest Gump", "PG-13", 142);

        // Save the movies to the database
        movieRepository.save(movie1);
        movieRepository.save(movie2);
        movieRepository.save(movie3);
        movieRepository.save(movie4);
        movieRepository.save(movie5);
    }
}