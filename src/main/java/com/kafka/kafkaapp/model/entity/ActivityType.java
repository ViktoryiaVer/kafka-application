package com.kafka.kafkaapp.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ActivityType {
    COMMENT_ADDED("Comment added"),
    COMMENT_REMOVED("Comment removed");

    private final String value;
}
