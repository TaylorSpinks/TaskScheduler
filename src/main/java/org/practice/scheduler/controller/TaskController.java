package org.practice.scheduler.controller;

import org.practice.scheduler.model.TaskModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @PostMapping
    public TaskModel RunTasks() {
        return new TaskModel();
    }

    @GetMapping("inventory")
    public List<TaskModel> GetInventory(){
        List<TaskModel> inventory = new ArrayList<>();
        return inventory;
    }
}
