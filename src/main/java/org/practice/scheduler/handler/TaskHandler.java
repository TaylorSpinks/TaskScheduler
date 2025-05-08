package org.practice.scheduler.handler;

import org.practice.scheduler.model.TaskModel;
import org.practice.scheduler.service.InventoryService;
import org.practice.scheduler.service.ThreadService;

import java.util.ArrayList;

public class TaskHandler {
    public static void createTasksToRun(ArrayList<TaskModel> tasks) throws InterruptedException {
        InventoryService inventoryService = new InventoryService();
        ThreadService threadService = new ThreadService(inventoryService);

        threadService.runTasks(tasks);
    }
}
