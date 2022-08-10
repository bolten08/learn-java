//package com.learn.java.repository;
//
//import com.learn.java.entity.MovieEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
//    Optional<MovieEntity> findByName(String name);
//
//    Optional<MovieEntity> findById(Long id);
//
//    List<MovieEntity> findByGenresId(Integer genreId);
//}
