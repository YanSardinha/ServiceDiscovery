package com.yansardinha.task_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = "com.yansardinha.*")
@EntityScan(basePackages = "com.yansardinha.*")
@ComponentScan(basePackages = "com.yansardinha.*")
public class TaskManagerApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TaskManagerApplication.class);
        Environment env = app.run(args).getEnvironment();
        System.out.println("Task Manager is running on Port: http://localhost:" + env.getProperty("local.server.port"));
    }
}
