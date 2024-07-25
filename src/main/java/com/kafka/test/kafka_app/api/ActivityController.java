package com.kafka.test.kafka_app.api;

import com.kafka.test.kafka_app.api.dto.ActivityDto;
import com.kafka.test.kafka_app.control.ActivityService;
import com.kafka.test.kafka_app.mapper.ActivityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/activities")
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityService activityService;
    private final ActivityMapper activityMapper;

    @GetMapping
    public List<ActivityDto> getActivities() {
        return activityService.getAllActivities().stream().map((activityMapper::toDto)).toList();
    }
}
