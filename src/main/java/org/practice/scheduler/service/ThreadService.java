package org.practice.scheduler.service;

import org.practice.scheduler.entities.InventoryItem;
import org.practice.scheduler.model.TaskModel;

import java.util.ArrayList;
import java.util.Map;

public class ThreadService {

    private final InventoryService inventoryService;

    public ThreadService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public Map<InventoryItem,Integer> runTasks(ArrayList<TaskModel> tasks) throws InterruptedException {

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
