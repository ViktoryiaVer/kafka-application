package com.kafka.kafkaapp.api.dto;

import com.kafka.kafkaapp.model.entity.ActivityType;
import lombok.Builder;
import lombok.Value;

import java.sql.Timestamp;
import java.util.UUID;

@Value
@Builder
public class ActivityDto {
    UUID id;

    ActivityType activityType;

    String authorName;

    String activityDescription;

    Timestamp createdOn;
}
