package org.practice.scheduler.model;

import org.practice.scheduler.entities.InventoryItem;
import org.practice.scheduler.enums.InventoryOperationType;

import java.util.List;

public class TaskModel {
    private InventoryOperationType operationType;
    private InventoryItem inventoryItem;

    public InventoryItem getInventoryItems() {
        return inventoryItem;
    }

    public InventoryOperationType getOperationType() {
        return operationType;
    }


    public void setInventoryItem(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    public void setOperationType(InventoryOperationType operationType) {
        this.operationType = operationType;
    }

}
