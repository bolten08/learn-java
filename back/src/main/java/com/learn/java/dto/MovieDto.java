//package com.learn.java.dto;
//
//import com.learn.java.config.AppConfig;
//import com.learn.java.entity.GenreEntity;
//import com.learn.java.entity.MovieEntity;
//
//import java.util.Objects;
//import java.util.Set;
//
//public class MovieDto {
//    private Long id;
//    private String name;
//    private String description;
//    private Integer releaseDate;
//    private Set<GenreEntity> genres;
//    private ImageDto poster;
//
//    public static MovieDto toModel(AppConfig appConfig, MovieEntity entity) {
//        MovieDto model = new MovieDto();
//        model.setId(entity.getId());
//        model.setName(entity.getName());
//        model.setDescription(entity.getDescription());
//        model.setGenres(entity.getGenres());
//        model.setReleaseDate(entity.getReleaseDate());
//        if (Objects.nonNull(entity.getPoster())) {
//            model.setPoster(ImageDto.toModel(appConfig, entity.getPoster()));
//        }
//
//        return model;
//    }
//
////    public static MovieEntity toEntity(MovieDto model) {
////        MovieEntity entity = new MovieEntity();
////        entity.setId(model.getId());
////        entity.setName(model.getName());
////        entity.setDescription(model.getDescription());
////        entity.setReleaseDate(model.getReleaseDate());
////        entity.setGenres(model.getGenres());
////        entity.setPoster(ImageDto.toModel(appConfig, entity.getPoster()));
////
////        return entity;
////    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Integer getReleaseDate() {
//        return releaseDate;
//    }
//
//    public void setReleaseDate(Integer releaseDate) {
//        this.releaseDate = releaseDate;
//    }
//
//    public Set<GenreEntity> getGenres() {
//        return genres;
//    }
//
//    public void setGenres(Set<GenreEntity> genres) {
//        this.genres = genres;
//    }
//
//    public ImageDto getPoster() {
//        return poster;
//    }
//
//    public void setPoster(ImageDto poster) {
//        this.poster = poster;
//    }
//}
