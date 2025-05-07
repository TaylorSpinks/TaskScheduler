package org.practice.scheduler.reppository;


import org.practice.scheduler.entities.InventoryItem;

import java.util.Map;

public interface InventoryRepository {
    void add(InventoryItem item, int quantity);

    void remove(InventoryItem item);
    void update(InventoryItem item, int quantity);
    int getQuantity(InventoryItem item);
    Map<InventoryItem, Integer> getAll();
}
