package com.kafka.test.kafka_app.api;

import com.kafka.test.kafka_app.api.dto.CommentDto;
import com.kafka.test.kafka_app.control.CommentService;
import com.kafka.test.kafka_app.kafka.KafkaProducer;
import com.kafka.test.kafka_app.mapper.CommentMapper;
import com.kafka.test.kafka_app.model.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final CommentMapper commentMapper;
    private final KafkaProducer kafkaProducer;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto addComment(@RequestBody CommentDto commentDto) {
        Comment savedComment = commentService.saveComment(commentMapper.toEntity(commentDto));
        CommentDto savedCommentDto = commentMapper.toDto(savedComment);
        kafkaProducer.sendComment("comments", savedCommentDto);
        return savedCommentDto;
    }
}
