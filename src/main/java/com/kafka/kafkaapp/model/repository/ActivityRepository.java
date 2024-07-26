package com.kafka.kafkaapp.model.repository;

import com.kafka.kafkaapp.model.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActivityRepository extends JpaRepository<Activity, UUID> {}
