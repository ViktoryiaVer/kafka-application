package com.kafka.kafkaapp.model.repository;

import com.kafka.kafkaapp.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {}
