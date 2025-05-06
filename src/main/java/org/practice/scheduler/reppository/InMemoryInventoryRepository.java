package org.practice.scheduler.reppository;

import org.practice.scheduler.entities.InventoryItem;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryInventoryRepository implements InventoryRepository {

    private final ConcurrentHashMap<InventoryItem, AtomicInteger> inventory = new ConcurrentHashMap<>();

    @Override
    public void add(InventoryItem item) {
        inventory.computeIfAbsent(item, k -> new AtomicInteger(0)).addAndGet(item.quantity());
    }

    @Override
    public void remove(InventoryItem item) {
        inventory.remove(item);
    }

    @Override
    public void update(InventoryItem item) {
        AtomicInteger current = this.inventory.computeIfAbsent(item, k -> new AtomicInteger(0));
        current.getAndAdd(item.quantity());
    }

    @Override
    public int getQuantity(InventoryItem item) {
        return 0;
    }

    @Override
    public Map<InventoryItem, Integer> getAll() {
        return Map.of();
    }
}
