package com.kafka.kafkaapp.control;

import com.kafka.kafkaapp.model.entity.Comment;
import com.kafka.kafkaapp.model.repository.CommentRepository;
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
