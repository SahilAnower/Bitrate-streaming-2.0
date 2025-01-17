package com.bitrate.videoMetadataService.service.impl;

import com.bitrate.videoMetadataService.dto.VideoMetadataDto;
import com.bitrate.videoMetadataService.mapper.GenericMapper;
import com.bitrate.videoMetadataService.repository.VideoMetadataRepository;
import com.bitrate.videoMetadataService.service.IVideoMetadataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoMetadataServiceImpl implements IVideoMetadataService {

    private final GenericMapper genericMapper;

    private final VideoMetadataRepository videoMetadataRepository;

    @Override
    public void create(VideoMetadataDto videoMetadataDto) {
        videoMetadataRepository
                .save(genericMapper.toVideoMetadata(videoMetadataDto));
    }

    @Override
    public List<VideoMetadataDto> getAll(Long userId) {
        return videoMetadataRepository
                .findAllByUserId(userId)
                .stream().map(genericMapper::toVideoMetadataDto).toList();
    }
}
