package com.shms.controller;

import java.io.File;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
public class FileUploadController {

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {

        try {
            String path = "C:/uploads/";

            File dir = new File(path);

            if (!dir.exists()) {
                dir.mkdirs();
            }

            file.transferTo(
                new File(path + file.getOriginalFilename())
            );

            return "File Uploaded Successfully";

        } catch (Exception e) {
            return "Upload Failed: " + e.getMessage();
        }
    }
}