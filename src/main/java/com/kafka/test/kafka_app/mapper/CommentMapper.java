package com.kafka.test.kafka_app.mapper;

import com.kafka.test.kafka_app.api.dto.CommentDto;
import com.kafka.test.kafka_app.model.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommentMapper {
    CommentDto toDto(Comment comment);

    Comment toEntity(CommentDto commentDto);
}
