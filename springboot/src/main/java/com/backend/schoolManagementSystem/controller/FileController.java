package com.backend.schoolManagementSystem.controller;

import java.io.IOException;

import com.backend.schoolManagementSystem.model.File;
import com.backend.schoolManagementSystem.service.FileService;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/single/upload")
    public File singleFileUpload(@RequestParam("file") MultipartFile file){
        String fileName = fileService.storeFile(file);
        String downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                             .path("/download/")
                             .path(fileName)
                             .toUriString();
        String contentType = file.getContentType();

        File uploadedFile = new File(fileName, downloadUrl, contentType);
        return uploadedFile;
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request){
        Resource resource = fileService.downloadFile(fileName);
        String mimetype;
        try {
            mimetype = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException e) {
            mimetype = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }

        return ResponseEntity.ok()
               .contentType(MediaType.parseMediaType(mimetype))
               .header(HttpHeaders.CONTENT_DISPOSITION, "attatchment: fileName= " + resource.getFilename())
               .body(resource);
    }
    
}
