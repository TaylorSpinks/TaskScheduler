package org.practice.scheduler.service;

import org.practice.scheduler.entities.InventoryItem;
import org.practice.scheduler.enums.InventoryOperationType;

public class TaskService implements Runnable {
    private final InventoryService inventoryService;
    private final InventoryOperationType type;
    private final InventoryItem inventoryItem;
    private final int quantity;

    public TaskService(InventoryService inventoryService, InventoryOperationType type, InventoryItem inventoryItem, int quantity) {
        this.inventoryService = inventoryService;
        this.type = type;
        this.inventoryItem = inventoryItem;
        this.quantity = quantity;
    }

    public void run() {
        switch (type) {
            case ADD -> inventoryService.addStock(inventoryItem,quantity);
            case UPDATE -> inventoryService.updateStock(inventoryItem,quantity);
            case REMOVE -> inventoryService.removeStock(inventoryItem);
        }
    }
}
