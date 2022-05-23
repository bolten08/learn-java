package com.learn.java.dto.movie;

import com.learn.java.entity.GenreEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;

public class MovieDto {
    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @NotEmpty
    private Date releaseDate;

    @NotEmpty
    private Set<GenreEntity> genres;

    @NotEmpty
    private MultipartFile poster;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Set<GenreEntity> getGenres() {
        return genres;
    }

    public void setGenres(Set<GenreEntity> genres) {
        this.genres = genres;
    }

    public MultipartFile getPoster() {
        return poster;
    }

    public void setPoster(MultipartFile poster) {
        this.poster = poster;
    }
}
