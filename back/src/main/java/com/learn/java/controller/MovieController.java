package com.learn.java.controller;

import com.learn.java.dto.movie.MovieDto;
import com.learn.java.entity.MovieEntity;
import com.learn.java.exception.AlreadyExistException;
import com.learn.java.exception.NotFoundException;
import com.learn.java.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieEntity>> getAllMovies(@RequestParam(value = "genre", required = false) Integer genreId) {
        return ResponseEntity.ok(movieService.getAllMovies(genreId));
    }

    @GetMapping("/{id}")
    public ResponseEntity getMovie(@PathVariable("id") Long movieId) {
        try {
            return ResponseEntity.ok(movieService.getMovieById(movieId));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Ошибка");
        }
    }

    @PostMapping
    public ResponseEntity createMovie(@RequestBody MovieDto movie) {
        System.out.println(movie.getPoster());
        return ResponseEntity.ok().build();
//        try {
//            return ResponseEntity.ok(movieService.createMovie(movie));
//        } catch (AlreadyExistException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body("Ошибка");
//        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateMovie(
            @PathVariable("id") Long movieId,
            @RequestBody MovieEntity movieEntity
    ) {
        try {
            return ResponseEntity.ok(movieService.updateMovie(movieId, movieEntity));
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovie(@PathVariable("id") Long movieId) {
        try {
            movieService.deleteMovie(movieId);
            return ResponseEntity.ok().build();
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Ошибка");
        }
    }
}
