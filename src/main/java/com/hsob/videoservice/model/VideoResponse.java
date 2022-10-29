package com.hsob.videoservice.model;


import com.hsob.videoservice.entity.Video;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VideoResponse {
    private Long id;
    private String title;
    private String description;
    private String url;

    public VideoResponse(Video video) {
        this.id = video.getId();
        this.title = video.getTitle();
        this.description = video.getDescription();
        this.url = video.getUrl();
    }
}
