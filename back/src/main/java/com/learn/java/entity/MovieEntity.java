//package com.learn.java.entity;
//
//
////@Table(name = "movies")
//public class MovieEntity {
//    private Long id;
//
//    private String name;
//
//    private String description;
//
//    private Integer releaseDate;
//
//    @ManyToMany
//    @JoinTable(
//            name = "movies_genres",
//            joinColumns = @JoinColumn(name = "movie_id"),
//            inverseJoinColumns = @JoinColumn(name = "genre_id")
//    )
//    private Set<GenreEntity> genres;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "images_id", referencedColumnName = "id")
//    private ImageEntity poster;
//
//    public ImageEntity getPoster() {
//        return poster;
//    }
//
//    public void setPoster(ImageEntity poster) {
//        this.poster = poster;
//    }
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
//}
