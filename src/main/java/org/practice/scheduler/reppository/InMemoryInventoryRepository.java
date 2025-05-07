package org.practice.scheduler.reppository;

import org.practice.scheduler.entities.InventoryItem;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class InMemoryInventoryRepository implements InventoryRepository {

    private final ConcurrentHashMap<InventoryItem, AtomicInteger> inventory = new ConcurrentHashMap<>();

    @Override
    public void add(InventoryItem item, int quantity) {
        inventory.computeIfAbsent(item, k -> new AtomicInteger(0)).addAndGet(quantity);
    }

    @Override
    public void remove(InventoryItem item, int quantity) {
        inventory.remove(item);
    }

    @Override
    public void update(InventoryItem item, int quantity) {
        AtomicInteger current = this.inventory.computeIfAbsent(item, k -> new AtomicInteger(0));
        current.getAndAdd(quantity);
    }

    @Override
    public int getQuantity(InventoryItem item) {
        return 0;
    }

    @Override
    public Map<InventoryItem, Integer> getAll() {
        return inventory.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().get()
                ));
    }
}
