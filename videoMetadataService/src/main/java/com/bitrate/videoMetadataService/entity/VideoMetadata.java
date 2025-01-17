package com.bitrate.videoMetadataService.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "video_metadatas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VideoMetadata extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    private String title;

    private String description;

}
