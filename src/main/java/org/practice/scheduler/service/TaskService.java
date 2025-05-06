package org.practice.scheduler.service;

import org.practice.scheduler.entities.InventoryItem;
import org.practice.scheduler.enums.InventoryOperationType;

public class TaskService implements Runnable {
    private final InventoryService inventoryService;
    private final InventoryOperationType type;
    private final InventoryItem inventoryItem;

    public TaskService(InventoryService inventoryService, InventoryOperationType type, InventoryItem inventoryItem){
        this.inventoryService = inventoryService;
        this.type = type;
        this.inventoryItem = inventoryItem;
    }

    public void run(){
        switch (type){
            case ADD -> inventoryService.addStock(inventoryItem);
            case UPDATE -> inventoryService.updateStock(inventoryItem);
            case REMOVE -> inventoryService.removeStock(inventoryItem);
        }
    }
}
