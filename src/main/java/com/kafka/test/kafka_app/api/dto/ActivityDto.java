package com.kafka.test.kafka_app.api.dto;

import com.kafka.test.kafka_app.model.entity.ActivityType;
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
