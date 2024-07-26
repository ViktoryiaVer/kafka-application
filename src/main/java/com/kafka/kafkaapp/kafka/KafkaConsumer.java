package com.kafka.kafkaapp.kafka;

import com.kafka.kafkaapp.control.ActivityService;
import com.kafka.kafkaapp.api.dto.CommentDto;
import com.kafka.kafkaapp.model.entity.Activity;
import com.kafka.kafkaapp.model.entity.ActivityType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumer {
    private final ActivityService activityService;

    @KafkaListener(
            topics = "${kafka-test.topic-name}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void listenToComment(ConsumerRecord<String, CommentDto> commentRecord) {
        log.info("Received a message: {}", commentRecord);
        Activity activity =
                Activity.builder()
                        .activityType(ActivityType.COMMENT_ADDED)
                        .authorName(commentRecord.value().getAuthorName())
                        .activityDescription(commentRecord.value().getText())
                        .createdOn(new Timestamp(commentRecord.timestamp()))
                        .build();

        activityService.saveActivity(activity);
    }
}
