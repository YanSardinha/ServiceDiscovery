package com.yansardinha.user_service.service;

import com.yansardinha.user_service.client.TaskClient;
import com.yansardinha.user_service.model.Task;
import com.yansardinha.user_service.model.User;
import com.yansardinha.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final TaskClient taskClient;

    @Autowired
    public UserService(UserRepository userRepository, TaskClient taskClient) {
        this.userRepository = userRepository;
        this.taskClient = taskClient;
    }

    public User login(String username, String password) {
        return userRepository.findByUsername(username)
            .filter(user -> user.getPassword().equals(password))
            .orElse(null);
    }

    public List<Task> getUserTasks(Long userId) {
        return taskClient.getTasksByUserId(userId);
    }
}
