package com.bitrate.videoMetadataService.mapper;

import com.bitrate.videoMetadataService.dto.VideoMetadataDto;
import com.bitrate.videoMetadataService.entity.VideoMetadata;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface GenericMapper {

    VideoMetadataDto toVideoMetadataDto (VideoMetadata videoMetadata);

    VideoMetadata toVideoMetadata (VideoMetadataDto videoMetadataDto);

}
