package com.hsob.videoservice.service;

import com.hsob.videoservice.entity.Video;
import com.hsob.videoservice.model.VideoRequest;
import com.hsob.videoservice.model.VideoResponse;
import com.hsob.videoservice.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VideoService {
    @Autowired
    private VideoRepository videoRepository;
    public List<VideoResponse> getAlVideos(){
        List<VideoResponse> videoList = new ArrayList<>();
        List<Video> videos = videoRepository.findAll();
        videos.forEach(video -> videoList.add(new VideoResponse(video)));
        return videoList;
    }

    public VideoResponse getVideoById(Long id){
        Optional<Video> video = videoRepository.findById(id);
        if (video.isPresent()){
            return new VideoResponse(video.get());
        } else {
            throw new EntityNotFoundException("Video not found");
        }

    }

    public VideoRequest saveVideo(VideoRequest videoRequest) {
        try {
            videoRepository.save(videoRequest.toEntity());
            return videoRequest;
        } catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public VideoResponse updateVideo(VideoRequest video, Long id) {
        Optional<Video> video1 =  videoRepository.findById(id);
        if (video1.isPresent()){
            video1.get().setTitle(video.getTitle());
            video1.get().setDescription(video.getDescription());
            video1.get().setUrl(video.getUrl());
            videoRepository.save(video1.get());
            return new VideoResponse(video1.get());
        } else {
            throw new EntityNotFoundException("Video with id " + id + " not found.");
        }
    }

    public void deleteVideoById(Long id) {
        try {
            videoRepository.deleteById(id);
        } catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
