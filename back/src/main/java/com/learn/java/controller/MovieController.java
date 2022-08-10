//package com.learn.java.controller;
//
//import com.learn.java.dto.MovieCreateDto;
//import com.learn.java.dto.MovieDto;
//import com.learn.java.entity.MovieEntity;
//import com.learn.java.service.MovieService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//
//@RestController
//@RequestMapping("/api/movies")
//public class MovieController {
//    @Autowired
//    MovieService movieService;
//
//    @GetMapping
//    public ResponseEntity<List<MovieDto>> getAllMovies(@RequestParam(value = "genre", required = false) Integer genreId) {
//        System.out.println(genreId);
//        return ResponseEntity.ok(movieService.getAllMovies(genreId));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<MovieDto> getMovie(@PathVariable("id") Long movieId) {
//        return ResponseEntity.ok(movieService.getMovieById(movieId));
//    }
//
//    @PostMapping
//    public ResponseEntity createMovie(@RequestBody MovieCreateDto movie) {
//        return ResponseEntity.ok(movieService.createMovie(movie));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<MovieEntity> updateMovie(
//            @PathVariable("id") Long movieId,
//            @RequestBody MovieCreateDto movie
//    ) {
//        return ResponseEntity.ok(movieService.updateMovie(movieId, movie));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<HttpStatus> deleteMovie(@PathVariable("id") Long movieId) {
//        movieService.deleteMovie(movieId);
//        return ResponseEntity.ok().build();
//    }
//}
