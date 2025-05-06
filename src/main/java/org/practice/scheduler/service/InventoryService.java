package org.practice.scheduler.service;

import org.practice.scheduler.entities.InventoryItem;
import org.practice.scheduler.reppository.InMemoryInventoryRepository;

import java.util.Map;

public class InventoryService {
    private final InMemoryInventoryRepository inMemoryInventoryRepository = new InMemoryInventoryRepository();

    public void addStock(InventoryItem item){
        inMemoryInventoryRepository.add(item);

    }
    public void removeStock(InventoryItem item){
        inMemoryInventoryRepository.add(item);

    }
    public void updateStock(InventoryItem item){
        inMemoryInventoryRepository.add(item);
    }

    public Map<InventoryItem,Integer> getAllItems(){
        return Map.of();
    }
}
