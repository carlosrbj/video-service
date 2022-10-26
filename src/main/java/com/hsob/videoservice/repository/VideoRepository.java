package com.hsob.videoservice.repository;

import com.hsob.videoservice.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VideoRepository extends JpaRepository<Video, Long> {

    Optional<Video> findByTitle(String title);
    Optional<Video> findByUrl(String url);
}
