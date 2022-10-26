package com.hsob.videoservice.service;

import com.hsob.videoservice.entity.Video;
import com.hsob.videoservice.model.VideoRequest;
import com.hsob.videoservice.model.VideoResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {
    public List<VideoResponse> getAlVideos(){
        return new ArrayList<>();
    }

    public VideoResponse getVideoById(Long id){
        VideoResponse response = new VideoResponse();
        response.setTitle("Video id: " + id);
        return response;
    }

    public VideoRequest saveVideo(VideoRequest video) {
        VideoRequest response = new VideoRequest();
        response.setTitle("Novo Video Criado");
        return response;
    }

    public VideoRequest updateVideo(VideoRequest video, Long id) {
        VideoRequest response = new VideoRequest();
        response.setTitle("Video Atualizado");
        return response;
    }
}
