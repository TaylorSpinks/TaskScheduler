package org.practice.scheduler.controller;

import org.practice.scheduler.handler.TaskHandler;
import org.practice.scheduler.model.TaskModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @PostMapping
    public void RunTasks(@RequestBody ArrayList<TaskModel> tasks) throws InterruptedException {
        TaskHandler.createTasksToRun(tasks);
    }
}
