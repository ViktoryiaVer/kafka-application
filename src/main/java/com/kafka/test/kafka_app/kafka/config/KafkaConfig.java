package com.kafka.test.kafka_app.kafka.config;

import lombok.Getter;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Getter
@Configuration
public class KafkaConfig {

    @Bean
    public KafkaAdmin admin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(
                AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,
                "${spring.kafka.consumer.bootstrap-servers}");
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("${kafka-test.topic-name}")
                .partitions(1)
                .replicas(1)
                .config(TopicConfig.MESSAGE_TIMESTAMP_TYPE_DOC, "CreateTime")
                .build();
    }
}
