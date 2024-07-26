package com.kafka.kafkaapp.mapper;

import com.kafka.kafkaapp.api.dto.CommentDto;
import com.kafka.kafkaapp.model.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommentMapper {
    CommentDto toDto(Comment comment);

    Comment toEntity(CommentDto commentDto);
}
