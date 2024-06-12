package com.yansardinha.user_service.client;

import com.yansardinha.user_service.model.Task;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "task-manager")
public interface TaskClient {
    @GetMapping("/api/tasks/user/{userId}")
    List<Task> getTasksByUserId(@PathVariable("userId") Long userId);
}
