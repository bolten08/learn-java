package com.learn.java.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
public class StorageService {
    @Value("${upload.path}")
    private String uploadPath;

    public void save(MultipartFile file) throws IOException {
        File uploadDir = new File(uploadPath);
        System.out.println(uploadDir);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        String uuidFile = UUID.randomUUID().toString();
        String resultFileName = uploadDir + "/" + uuidFile + "." + file.getOriginalFilename();
        System.out.println(resultFileName);
        file.transferTo(new File(resultFileName));
    }

//    private Path getPath(WidgetDomain widget) {
//        return Paths.get(root.toString(), widget.getId().toString());
//    }
}
