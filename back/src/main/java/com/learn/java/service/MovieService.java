//package com.learn.java.service;
//
//import com.learn.java.config.AppConfig;
//import com.learn.java.dto.MovieCreateDto;
//import com.learn.java.dto.MovieDto;
//import com.learn.java.entity.GenreEntity;
//import com.learn.java.entity.MovieEntity;
//import com.learn.java.exception.AlreadyExistException;
//import com.learn.java.exception.NotFoundException;
//import com.learn.java.repository.GenreRepository;
//import com.learn.java.repository.MovieRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Service
//public class MovieService {
//    @Autowired
//    MovieRepository movieRepository;
//
//    @Autowired
//    GenreRepository genreRepository;
//
//    @Autowired
//    ImageService imageService;
//
//    @Autowired
//    AppConfig appConfig;
//
//    public List<MovieDto> getAllMovies(Integer genreId) {
//        List<MovieEntity> movies;
//        System.out.println(genreId);
//
//        if (genreId != null) {
//            movies = movieRepository.findByGenresId(genreId);
//        } else {
//            movies = movieRepository.findAll();
//        }
//
//        return movies
//                .stream()
//                .map(movieEntity -> MovieDto.toModel(appConfig, movieEntity))
//                .collect(Collectors.toList());
//    }
//
//    public MovieDto getMovieById(Long movieId) throws NotFoundException {
//        MovieEntity movieEntity = movieRepository
//                .findById(movieId)
//                .orElseThrow(() -> new NotFoundException("Фильм не найден"));
//
//        return MovieDto.toModel(appConfig, movieEntity);
//    }
//
//    public MovieEntity createMovie(MovieCreateDto movie) {
//        if (movieRepository.findByName(movie.getName()).isPresent()) {
//            throw new AlreadyExistException("Такой фильм уже существует");
//        }
//
//        MovieEntity movieEntity = createMovieEntity(movie);
//        return movieRepository.save(movieEntity);
//    }
//
//    public MovieEntity updateMovie(Long movieId, MovieCreateDto movie) throws NotFoundException {
//        if (movieRepository.findById(movieId).isEmpty()) {
//            throw new NotFoundException("Такого фильма не существует");
//        }
//
//        MovieEntity movieEntity = createMovieEntity(movie);
//        movieEntity.setId(movieId);
//        return movieRepository.save(movieEntity);
//    }
//
//    public void deleteMovie(Long movieId) throws NotFoundException {
//        if (movieRepository.findById(movieId).isEmpty()) {
//            throw new NotFoundException("Такого фильма не существует");
//        }
//        movieRepository.deleteById(movieId);
//    }
//
//    private MovieEntity createMovieEntity(MovieCreateDto movie) {
//        Set<GenreEntity> genreEntities = movie.getGenres()
//                .stream()
//                .map(genre -> Objects.isNull(genre.getId()) ? genreRepository.save(genre) : genre)
//                .collect(Collectors.toSet());
//
//        MovieEntity movieEntity = new MovieEntity();
//        movieEntity.setName(movie.getName());
//        movieEntity.setDescription(movie.getDescription());
//        movieEntity.setGenres(genreEntities);
//        movieEntity.setReleaseDate(movie.getReleaseDate());
//
//        if (movie.getPosterId() != null) {
//            try {
//                movieEntity.setPoster(imageService.getImage(movie.getPosterId()));
//            } catch (NotFoundException e) {
//                movieEntity.setPoster(null);
//            }
//        } else {
//            movieEntity.setPoster(null);
//        }
//        return movieEntity;
//    }
//}
