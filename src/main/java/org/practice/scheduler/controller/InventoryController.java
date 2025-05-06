package org.practice.scheduler.controller;

import org.practice.scheduler.model.TaskModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @GetMapping
    public List<TaskModel> GetInventory(){
        List<TaskModel> inventory = new ArrayList<>();
        return inventory;
    }
}
