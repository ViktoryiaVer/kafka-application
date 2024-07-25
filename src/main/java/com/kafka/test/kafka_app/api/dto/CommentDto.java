package com.kafka.test.kafka_app.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class CommentDto {
    UUID id;

    String text;

    String authorName;
}
