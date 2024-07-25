package com.kafka.test.kafka_app.model.repository;

import com.kafka.test.kafka_app.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {}
