package com.kafka.test.kafka_app.model.repository;

import com.kafka.test.kafka_app.model.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActivityRepository extends JpaRepository<Activity, UUID> {}
