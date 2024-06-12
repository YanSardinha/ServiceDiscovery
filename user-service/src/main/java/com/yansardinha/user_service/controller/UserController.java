package com.yansardinha.user_service.controller;

import com.yansardinha.user_service.model.Task;
import com.yansardinha.user_service.model.User;
import com.yansardinha.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }

    @GetMapping("/{userId}/tasks")
    public List<Task> getUserTasks(@PathVariable Long userId) {
        return userService.getUserTasks(userId);
    }

    @Autowired
    private Environment environment;

    @GetMapping("/port")
    public String getServerPort() {
        String port = environment.getProperty("local.server.port");
        return "User Service is running on port: " + port;
    }
}
