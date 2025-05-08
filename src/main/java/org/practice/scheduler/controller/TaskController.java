package org.practice.scheduler.controller;

import org.practice.scheduler.handler.TaskHandler;
import org.practice.scheduler.model.TaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskHandler taskHandler;

    @Autowired
    public TaskController(TaskHandler taskHandler){
        this.taskHandler = taskHandler;
    }

    @PostMapping
    public void RunTasks(@RequestBody List<TaskModel> tasks) throws InterruptedException {
        taskHandler.createTasksToRun(tasks);
    }
}
