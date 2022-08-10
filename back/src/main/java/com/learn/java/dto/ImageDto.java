//package com.learn.java.dto;
//
//import com.learn.java.config.AppConfig;
//import com.learn.java.entity.ImageEntity;
//
//public class ImageDto {
//    private Long id;
//    private String src;
//
//    public static ImageDto toModel(AppConfig appConfig, ImageEntity entity) {
//        ImageDto model = new ImageDto();
//        model.setId(entity.getId());
//        model.setSrc(appConfig.getImagePath() + entity.getFileName());
//        return model;
//    }
//
////    public static ImageEntity toEntity(ImageDto model) {
////        ImageEntity entity = new ImageEntity();
////        entity.setId(model.getId());
////        entity.setFileName(appConfig.getImagePath() + entity.getFileName());
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
//    public String getSrc() {
//        return src;
//    }
//
//    public void setSrc(String src) {
//        this.src = src;
//    }
//}
