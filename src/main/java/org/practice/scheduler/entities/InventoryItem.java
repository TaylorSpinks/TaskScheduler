package org.practice.scheduler.entities;

import java.util.Objects;

public record InventoryItem(String itemName, String itemType, int quantity) {

    public String getItemTypeAndName() {
        return this.itemName + " " + this.itemType + " " + this.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName);
    }

}
