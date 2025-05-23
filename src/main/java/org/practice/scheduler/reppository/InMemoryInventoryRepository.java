package org.practice.scheduler.reppository;

import org.practice.scheduler.entities.InventoryItem;
import org.springframework.stereotype.Repository;

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
    public void remove(InventoryItem item) {
        inventory.remove(item);
    }

    @Override
    public void update(InventoryItem item, int quantity) {
        inventory.compute(item, (currItem,atomicQuantity) -> {
            int currQuantity = (atomicQuantity != null) ? atomicQuantity.get() : 0;
            currQuantity = Math.max(0,currQuantity + quantity);
            return new AtomicInteger(currQuantity);
        });
    }

    @Override
    public int getQuantity(InventoryItem item) {
        AtomicInteger quantity = inventory.getOrDefault(item, new AtomicInteger(0));

        return quantity.get();
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
