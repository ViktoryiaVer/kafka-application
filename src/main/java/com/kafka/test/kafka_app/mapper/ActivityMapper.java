package com.kafka.test.kafka_app.mapper;

import com.kafka.test.kafka_app.api.dto.ActivityDto;
import com.kafka.test.kafka_app.model.entity.Activity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ActivityMapper {
    ActivityDto toDto(Activity activity);

    Activity toEntity(ActivityDto activityDto);
}
