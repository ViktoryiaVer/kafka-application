package com.kafka.kafkaapp.kafka;

import com.kafka.kafkaapp.api.dto.CommentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String, CommentDto> template;

    public void sendComment(String topic, CommentDto commentDto) {
        final var commentRecord =
                new ProducerRecord<>(topic, commentDto.getId().toString(), commentDto);
        CompletableFuture<SendResult<String, CommentDto>> future = template.send(commentRecord);
        future.whenComplete(
                (result, ex) -> {
                    if (ex == null) {
                        log.info("Sent comment {} to topic: {}", commentDto, topic);

                    } else {
                        log.error(ex.getMessage());
                    }
                });
    }
}
