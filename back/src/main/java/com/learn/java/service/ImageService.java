//package com.learn.java.service;
//
//import com.learn.java.config.AppConfig;
//import com.learn.java.dto.ImageDto;
//import com.learn.java.dto.MovieDto;
//import com.learn.java.entity.ImageEntity;
//import com.learn.java.entity.MovieEntity;
//import com.learn.java.exception.NotFoundException;
//import com.learn.java.repository.ImageRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.UUID;
//
//import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
//
//@Service
//public class ImageService {
//    @Autowired
//    ImageRepository imageRepository;
//
//    @Autowired
//    AppConfig appConfig;
//
//    private final Path uploadPath;
//
//    public ImageService(AppConfig appConfig) {
//        uploadPath = Paths.get(appConfig.getUploadDir());
//    }
//
//    public void init() {
//        try {
//            if (!Files.exists(uploadPath)) {
//                Files.createDirectories(uploadPath);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException("Could not initialize folder for upload!");
//        }
//    }
//
//    public ImageDto saveFile(MultipartFile file) {
//        try {
//            String fileName = UUID.randomUUID() + "." + file.getOriginalFilename();
//            Path filePath = Paths.get(uploadPath + "/" + fileName);
//            Files.copy(file.getInputStream(), filePath, REPLACE_EXISTING);
//
////            file.transferTo(new File(filePath.getName()));
//            ImageEntity imageEntity = new ImageEntity();
//            imageEntity.setFileName(fileName);
//
//            return ImageDto.toModel(appConfig, imageRepository.save(imageEntity));
//        } catch (Exception e) {
//            throw new RuntimeException("Не удалось сохранить файл. Error: " + e.getMessage());
//        }
//    }
//
//    public ImageEntity getImage(Long imageId) {
//        return imageRepository
//                .findById(imageId)
//                .orElseThrow(() -> new NotFoundException("Картинка не найдена"));
//    }
//
//    public void deleteFile(String fileName) {
//        Path filePath = Path.of(uploadPath + "/" + fileName);
//        try {
//            Files.deleteIfExists(filePath);
//        } catch (Exception e) {
//            throw new RuntimeException("Не удалось удалить файл. Error: " + e.getMessage());
//        }
//    }
//}
