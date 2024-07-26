package com.kafka.kafkaapp.mapper;

import com.kafka.kafkaapp.api.dto.ActivityDto;
import com.kafka.kafkaapp.model.entity.Activity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ActivityMapper {
    ActivityDto toDto(Activity activity);

    Activity toEntity(ActivityDto activityDto);
}
