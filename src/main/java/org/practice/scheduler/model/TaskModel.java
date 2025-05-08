package org.practice.scheduler.model;

import org.practice.scheduler.entities.InventoryItem;
import org.practice.scheduler.enums.InventoryOperationType;

public class TaskModel {
    private InventoryOperationType operationType;
    private InventoryItem inventoryItem;
    private int quantity;

    public TaskModel() {}

    public InventoryItem getInventoryItem() {
        return inventoryItem;
    }

    public InventoryOperationType getOperationType() {
        return operationType;
    }

    public int getQuantity(){
        return quantity;
    }


    public void setInventoryItem(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    public void setOperationType(InventoryOperationType operationType) {
        this.operationType = operationType;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
