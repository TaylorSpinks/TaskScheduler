package org.practice.scheduler.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @GetMapping
    public String hello() {
        return "Task Scheduler is live!";
    }
}
