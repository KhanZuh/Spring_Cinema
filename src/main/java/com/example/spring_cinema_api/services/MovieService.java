package com.example.spring_cinema_api.services;

import com.example.spring_cinema_api.models.Movie;
import com.example.spring_cinema_api.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie updatedMovie) {                   // Using movieRepository.findById(id).orElse(null) to retrieve the movie by its ID. If the movie is not found, returns null. If the movie is found, update its properties and saves the changes to the database using movieRepository.save(movie) --> return the updated movie.
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie != null) {
            movie.setTitle(updatedMovie.getTitle());
            movie.setRating(updatedMovie.getRating());
            movie.setDuration(updatedMovie.getDuration());
            return movieRepository.save(movie);
        } else {
            return null;
        }
    }

    public boolean deleteMovie(Long id) {                                               //  Using movieRepository.findById(id).orElse(null) to retrieve the movie by its ID. If the movie is not found, return false. If the movie is found, delete it from the database using movieRepository.delete(movie) and return true.
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie != null) {
            movieRepository.delete(movie);
            return true;
        } else {
            return false;
        }
    }


}
