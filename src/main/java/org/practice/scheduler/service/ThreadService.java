package org.practice.scheduler.service;

import org.practice.scheduler.entities.InventoryItem;
import org.practice.scheduler.model.TaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ThreadService {

    private final InventoryService inventoryService;

    @Autowired
    public ThreadService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public Map<InventoryItem,Integer> runTasks(List<TaskModel> tasks) throws InterruptedException {

        ArrayList<Thread> threadsToRun = new ArrayList<>();

        for (TaskModel taskModel : tasks) {
            TaskService task = new TaskService(inventoryService, taskModel.getOperationType(), taskModel.getInventoryItem(), taskModel.getQuantity());
            threadsToRun.add(new Thread(task));
        }

        for(Thread thread : threadsToRun){
            thread.start();
        }

        for(Thread thread : threadsToRun){
            thread.join();
        }

        return inventoryService.getAllItems();
    }
}
