package com.example.spring_cinema_api.controllers;

import com.example.spring_cinema_api.models.Movie;
import com.example.spring_cinema_api.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Movie movie = movieService.getMovieById(id);
        if (movie != null) {
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie createdMovie = movieService.createMovie(movie);
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")                                                                                                // Method receives movie id as path variable and the updated movie object in the request body. -
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie updatedMovie) {                  // Calls the updateMovie method from the movieService, passing the ID and updated movie.
Movie movie = movieService.updateMovie(id, updatedMovie);                                                               // If the movie is found and successfully updated, the method returns the updated movie with an HTTP status of 200 (OK). - If the movie is not found (i.e., null is returned from the service), the method returns an HTTP status of 404 (Not Found).
        if (movie != null) {
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {                                                    // The method receives the movie ID as a path variable.
        boolean deleted = movieService.deleteMovie(id);                                                                 // It calls the deleteMovie method from the movieService, passing the ID.
        if (deleted) {                                                                                                  // If the movie is found and successfully deleted, the method returns an HTTP status of 204 (No Content).
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);                                                             // If the movie is not found (i.e., false is returned from the service), the method returns an HTTP status of 404 (Not Found).
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }






}




    






