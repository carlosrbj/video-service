package com.hsob.videoservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "video")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max=100)
    @Setter
    private String title;

    @NotBlank
    @Size(max=150)
    @Setter
    private String description;

    @NotBlank
    @Size(max=200)
    @Setter
    private String url;

    public Video(String title, String description, String url) {
        this.title = title;
        this.description = description;
        this.url = url;
    }
}
