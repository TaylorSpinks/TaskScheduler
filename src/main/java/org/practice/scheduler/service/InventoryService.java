package org.practice.scheduler.service;

import org.practice.scheduler.entities.InventoryItem;
import org.practice.scheduler.reppository.InMemoryInventoryRepository;

import java.util.Map;
import java.util.logging.Logger;

public class InventoryService {
    private final InMemoryInventoryRepository inMemoryInventoryRepository = new InMemoryInventoryRepository();

    public void addStock(InventoryItem item, int quantity){
        inMemoryInventoryRepository.add(item, quantity);
    }

    public void removeStock(InventoryItem item){
        inMemoryInventoryRepository.remove(item);

    }

    public void updateStock(InventoryItem item, int quantity){
        inMemoryInventoryRepository.update(item, quantity);
    }

    public Map<InventoryItem,Integer> getAllItems(){
        return inMemoryInventoryRepository.getAll();
    }
}
