package org.practice.scheduler.controller;

import org.practice.scheduler.model.TaskModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @PostMapping
    public TaskModel RunTasks() {
        return new TaskModel();
    }
}
