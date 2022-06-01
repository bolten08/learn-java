package com.learn.java.service;

import com.learn.java.config.AppConfig;
import com.learn.java.dto.ImageDto;
import com.learn.java.dto.MovieDto;
import com.learn.java.dto.genre.GenreDto;
import com.learn.java.entity.GenreEntity;
import com.learn.java.entity.ImageEntity;
import com.learn.java.entity.MovieEntity;
import com.learn.java.exception.AlreadyExistException;
import com.learn.java.exception.NotFoundException;
import com.learn.java.repository.GenreRepository;
import com.learn.java.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    ImageService imageService;

    @Autowired
    AppConfig appConfig;

    public List<MovieDto> getAllMovies(Integer genreId) {
        List<MovieEntity> movies;
        System.out.println(genreId);

        if (genreId != null) {
            movies = movieRepository.findByGenresId(genreId);
        } else {
            movies = movieRepository.findAll();
        }

        return movies
                .stream()
                .map(movieEntity -> MovieDto.toModel(appConfig, movieEntity))
                .collect(Collectors.toList());
    }

    public MovieDto getMovieById(Long movieId) throws NotFoundException {
        MovieEntity movieEntity = movieRepository
                .findById(movieId)
                .orElseThrow(() -> new NotFoundException("Фильм не найден"));

        return MovieDto.toModel(appConfig, movieEntity);
    }

    public MovieEntity createMovie(MovieDto movie) {
        if (movieRepository.findByName(movie.getName()).isPresent()) {
            throw new AlreadyExistException("Такой фильм уже существует");
        }

        Set<GenreEntity> genreEntities = movie.getGenres()
                .stream()
                .map(genre -> genre.getId() == null ? genreRepository.save(genre) : genre)
                .collect(Collectors.toSet());

        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setName(movie.getName());
        movieEntity.setDescription(movie.getDescription());
        movieEntity.setGenres(genreEntities);
        movieEntity.setReleaseDate(movie.getReleaseDate());

        if (Objects.nonNull(movie.getPoster())) {
            try {
                movieEntity.setPoster(imageService.getImage(movie.getPoster().getId()));
            } catch (NotFoundException e) {
                movieEntity.setPoster(null);
            }
        } else {
            movieEntity.setPoster(null);
        }

        return movieRepository.save(movieEntity);
    }

    public MovieEntity updateMovie(Long movieId, MovieDto movie) throws NotFoundException {
        if (movieRepository.findById(movieId).isEmpty()) {
            throw new NotFoundException("Такого фильма не существует");
        }
        Set<GenreEntity> genreEntities = movie.getGenres()
                .stream()
                .map(genre -> genre.getId() == null ? genreRepository.save(genre) : genre)
                .collect(Collectors.toSet());

        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setId(movie.getId());
        movieEntity.setName(movie.getName());
        movieEntity.setDescription(movie.getDescription());
        movieEntity.setGenres(genreEntities);
        movieEntity.setReleaseDate(movie.getReleaseDate());

        if (Objects.nonNull(movie.getPoster())) {
            try {
                movieEntity.setPoster(imageService.getImage(movie.getPoster().getId()));
            } catch (NotFoundException e) {
                movieEntity.setPoster(null);
            }
        } else {
            movieEntity.setPoster(null);
        }
        return saveMovie(movieEntity);
    }

    public void deleteMovie(Long movieId) throws NotFoundException {
        Optional<MovieEntity> movie = movieRepository.findById(movieId);
        if (movieRepository.findById(movieId).isEmpty()) {
            throw new NotFoundException("Такого фильма не существует");
        }
        movieRepository.deleteById(movieId);
    }

    private MovieEntity saveMovie(MovieEntity movie) {
        Set<GenreEntity> genres = movie
                .getGenres()
                .stream()
                .map(genre -> genre.getId() == null ? genreRepository.save(genre) : genre)
                .collect(Collectors.toSet());
        movie.setGenres(genres);
        System.out.println(movie);
        return movieRepository.save(movie);
    }
}
