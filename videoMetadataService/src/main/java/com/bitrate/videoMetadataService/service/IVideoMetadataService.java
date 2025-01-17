package com.bitrate.videoMetadataService.service;

import com.bitrate.videoMetadataService.dto.VideoMetadataDto;

import java.util.List;

public interface IVideoMetadataService {

    void create(VideoMetadataDto videoMetadataDto);

    List<VideoMetadataDto> getAll(Long userId);

}
