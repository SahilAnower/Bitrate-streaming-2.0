package com.bitrate.videoMetadataService.controller;

import com.bitrate.videoMetadataService.constants.VideoMetadataConstants;
import com.bitrate.videoMetadataService.dto.ResponseDto;
import com.bitrate.videoMetadataService.dto.VideoMetadataDto;
import com.bitrate.videoMetadataService.service.IVideoMetadataService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/video-metadata", produces = {"application/json"})
@RequiredArgsConstructor
@Validated
public class VideoMetadataController {

    private final IVideoMetadataService iVideoMetadataService;

    @PostMapping("/")
    public ResponseEntity<ResponseDto> create(@Valid @RequestBody VideoMetadataDto videoMetadataDto) {
        iVideoMetadataService.create(videoMetadataDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(VideoMetadataConstants.STATUS_201, VideoMetadataConstants.MESSAGE_201));
    }

    @GetMapping("/")
    public ResponseEntity<List<VideoMetadataDto>> getAll() {
        Long userId = null; // todo: get userId from request header
        List<VideoMetadataDto> videoMetadataDtos = iVideoMetadataService.getAll(userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(videoMetadataDtos);
    }

}
