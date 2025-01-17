package com.bitrate.videoMetadataService.repository;

import com.bitrate.videoMetadataService.entity.VideoMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoMetadataRepository extends JpaRepository<VideoMetadata, Long> {

    List<VideoMetadata> findAllByUserId(Long userId);

}
