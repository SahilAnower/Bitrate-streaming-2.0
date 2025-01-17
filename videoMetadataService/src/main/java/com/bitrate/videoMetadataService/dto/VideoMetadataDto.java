package com.bitrate.videoMetadataService.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoMetadataDto {

    private Long id;

    @NotNull
    private Long userId;

    @NotNull
    @NotEmpty
    private String title;

    private String description;

}
