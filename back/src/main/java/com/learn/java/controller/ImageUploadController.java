//package com.learn.java.controller;
//
//import com.learn.java.dto.ImageDto;
//import com.learn.java.service.ImageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestController
//@RequestMapping("/api/upload")
//public class ImageUploadController {
//
//    @Autowired
//    ImageService imageService;
//
//    @PostMapping("/images")
//    public ResponseEntity<ImageDto> uploadFile(@RequestParam("image") MultipartFile image) {
//        return ResponseEntity.ok(imageService.saveFile(image));
//    }
//
//}
