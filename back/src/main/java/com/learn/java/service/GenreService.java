package com.learn.java.service;

import com.learn.java.entity.GenreEntity;
import com.learn.java.exception.AlreadyExistException;
import com.learn.java.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    GenreRepository genreRepository;

    public List<GenreEntity> getGenres() {
        return genreRepository.findAll();
    }

    public GenreEntity createGenre(GenreEntity genre) throws AlreadyExistException {
        if (genreRepository.findByName(genre.getName()).isPresent()) {
            throw new AlreadyExistException("Такой жанр уже существует");
        }
        return genreRepository.save(genre);
    }
}
