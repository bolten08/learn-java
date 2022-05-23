package com.learn.java.service;

import com.learn.java.dto.movie.MovieDto;
import com.learn.java.entity.GenreEntity;
import com.learn.java.entity.MovieEntity;
import com.learn.java.exception.AlreadyExistException;
import com.learn.java.exception.NotFoundException;
import com.learn.java.repository.GenreRepository;
import com.learn.java.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    GenreRepository genreRepository;

    @Value("${upload.path}")
    private String uploadPath;

    public List<MovieEntity> getAllMovies(Integer genreId) {
        if (genreId != null) {
            return movieRepository.findByGenresId(genreId);
        } else {
            return movieRepository.findAll();
        }
    }

    public MovieEntity getMovieById(Long movieId) throws NotFoundException {
        MovieEntity movie = movieRepository
                .findById(movieId)
                .orElseThrow(() -> new NotFoundException("Фильм не найден"));

        return movie;
    }

    public MovieDto createMovie(MovieDto movie) throws AlreadyExistException {
        if (movieRepository.findByName(movie.getName()).isPresent()) {
            throw new AlreadyExistException("Такой фильм уже существует");
        }

        MultipartFile poster = movie.getPoster();
        System.out.println(poster);
//        String posterUrl = "";
//        try {
//            posterUrl = fileSystemRepository.save(poster.getBytes(), poster.getOriginalFilename());
//        } catch (Exception e) {
//            System.out.println(e);
//        }

//        MovieEntity movieEntity = new MovieEntity();
//        movieEntity.setName(movie.getName());
//        movieEntity.setDescription(movie.getDescription());
//        movieEntity.setGenres(movie.getGenres());
//        movieEntity.setReleaseDate(movie.getReleaseDate());
//        movieEntity.setPosterUrl(posterUrl);
//
//        return saveMovie(movieEntity);
        return movie;
    }

    public MovieEntity updateMovie(Long movieId, MovieEntity movie) throws NotFoundException {
        if (movieRepository.findById(movieId).isEmpty()) {
            throw new NotFoundException("Такого фильма не существует");
        }
        movie.setId(movieId);
        return saveMovie(movie);
    }

    public void deleteMovie(Long movieId) throws NotFoundException {
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
        return movieRepository.save(movie);
    }
}
