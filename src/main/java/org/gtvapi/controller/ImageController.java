package org.gtvapi.controller;

import lombok.RequiredArgsConstructor;
import org.gtvapi.service.ImageService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@RestController
@RequiredArgsConstructor
@RequestMapping("/images")
public class ImageController {

    private final ImageService imageService;

    @GetMapping("channel-icon/{imageName}")
    public ResponseEntity<Resource> getVideosByCategory(@PathVariable String imageName){
        Resource fileResource = imageService.getVideosByCategoryId(imageName);

        return ResponseEntity.ok()
                .header(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*") // CORS header!
                .contentType(MediaType.IMAGE_JPEG) // veya JPEG ise image/jpeg
                .body(fileResource);

    }

}
