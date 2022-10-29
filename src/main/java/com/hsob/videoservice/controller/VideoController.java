package com.hsob.videoservice.controller;

import com.hsob.videoservice.entity.Video;
import com.hsob.videoservice.model.VideoRequest;
import com.hsob.videoservice.model.VideoResponse;
import com.hsob.videoservice.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping
    public ResponseEntity<List<VideoResponse>> getAllVideos(){
        return ResponseEntity.ok(videoService.getAlVideos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoResponse> getvideoByIde(@PathVariable("id") Long id){
        return ResponseEntity.ok(videoService.getVideoById(id));
    }

    @PostMapping
    public ResponseEntity<VideoRequest> saveVideo(@RequestBody @Valid VideoRequest video, UriComponentsBuilder uriBuilder){
        VideoRequest videoCreated = videoService.saveVideo(video);
        URI uri = uriBuilder.path("/video/{id}")
                .buildAndExpand(videoCreated.getTitle())
                .toUri();
        return ResponseEntity.created(uri).body(videoCreated);

    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoResponse> updateVideo(@PathVariable Long id, @RequestBody @Valid VideoRequest video, UriComponentsBuilder uriBuilder){
        VideoResponse videoUpdated = videoService.updateVideo(video, id);
        URI uri = uriBuilder.path("/video/{id}")
                .buildAndExpand(videoUpdated.getId())
                .toUri();
        return ResponseEntity.created(uri).body(videoUpdated);

    }

    @PostMapping("/{id}")
    public ResponseEntity<VideoResponse> deleteVideo(@PathVariable Long id){
        videoService.deleteVideoById(id);
        return ResponseEntity.ok().build();
    }

}
