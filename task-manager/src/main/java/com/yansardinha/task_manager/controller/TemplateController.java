package com.yansardinha.task_manager.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {

    @GetMapping("/tasks")
    public String showTemplate1() {
        return "tasks"; 
    }

    @GetMapping("/edit-task")
    public String showTemplate2() {
        return "edit-task";
    }
}
