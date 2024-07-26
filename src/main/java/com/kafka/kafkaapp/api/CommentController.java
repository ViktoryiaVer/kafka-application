package com.kafka.kafkaapp.api;

import com.kafka.kafkaapp.api.dto.CommentDto;
import com.kafka.kafkaapp.control.CommentService;
import com.kafka.kafkaapp.kafka.KafkaProducer;
import com.kafka.kafkaapp.kafka.config.KafkaConfig;
import com.kafka.kafkaapp.mapper.CommentMapper;
import com.kafka.kafkaapp.model.entity.Comment;
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
    private final KafkaConfig kafkaConfig;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto addComment(@RequestBody CommentDto commentDto) {
        Comment savedComment = commentService.saveComment(commentMapper.toEntity(commentDto));
        CommentDto savedCommentDto = commentMapper.toDto(savedComment);
        kafkaProducer.sendComment(kafkaConfig.getTopicName(), savedCommentDto);
        return savedCommentDto;
    }
}
