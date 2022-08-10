//package com.learn.java.controller;
//
//import com.learn.java.entity.GenreEntity;
//import com.learn.java.exception.AlreadyExistException;
//import com.learn.java.service.GenreService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/genres")
//public class GenreController {
//
//    @Autowired
//    GenreService genreService;
//
//    @GetMapping
//    public ResponseEntity<List<GenreEntity>> getGenres() {
//        return ResponseEntity.ok(genreService.getGenres());
//    }
//
//    @PostMapping
//    public ResponseEntity createGenre(@RequestBody GenreEntity genre) {
//        System.out.println("Controller createGenre");
//        try {
//            return ResponseEntity.ok(genreService.createGenre(genre));
//        } catch (AlreadyExistException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body("Ошибка");
//        }
//    }
//
////    @PostMapping
////    public ResponseEntity<GenreEntity> createGenre(@RequestBody GenreEntity genre) {
////        System.out.println("Controller createGenre");
////        return ResponseEntity.ok(genreService.createGenre(genre));
////    }
//}
