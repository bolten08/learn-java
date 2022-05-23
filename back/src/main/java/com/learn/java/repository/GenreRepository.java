package com.learn.java.repository;

import com.learn.java.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<GenreEntity, Integer> {
    Optional<GenreEntity> findByName(String name);
}
