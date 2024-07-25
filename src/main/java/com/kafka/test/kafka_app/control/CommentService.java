package com.kafka.test.kafka_app.control;

import com.kafka.test.kafka_app.model.entity.Comment;
import com.kafka.test.kafka_app.model.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
