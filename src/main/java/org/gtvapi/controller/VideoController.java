package org.gtvapi.controller;

import lombok.RequiredArgsConstructor;
import org.gtvapi.dto.requestdto.VideoRequestDTO;
import org.gtvapi.dto.responsedto.VideoResponseDTO;
import org.gtvapi.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/videos")
public class VideoController {

    private final VideoService videoService;

    @GetMapping
    public ResponseEntity<List<VideoResponseDTO>> getAllVideos(){
        return new ResponseEntity<>(videoService.getVideos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> saveVideo(@RequestBody VideoRequestDTO videoRequestDTO) throws IOException, org.gtvapi.exception.IOException.WrongParameters {
        videoService.saveVideo(videoRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("categories/{categoryId}")
    public ResponseEntity<List<VideoResponseDTO>> getVideosByCategory(@PathVariable Long categoryId){
        List<VideoResponseDTO> videoDTOList = videoService.getVideosByCategoryId(categoryId);
        return new ResponseEntity<>(videoDTOList, HttpStatus.OK);
    }

}
