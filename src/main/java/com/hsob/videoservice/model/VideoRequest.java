package com.hsob.videoservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hsob.videoservice.entity.Video;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VideoRequest {
    @Size(max=100)
    @NotBlank
    @JsonProperty
    private String title;
    @Size(max=150)
    @NotBlank
    @JsonProperty
    private String description;
    @Size(max=200)
    @NotBlank
    @JsonProperty
    private String url;

    public Video toEntity(){
        return new Video(title, description, url);
    }
}
