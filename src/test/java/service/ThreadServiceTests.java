package service;

import helpers.CreateTasksHelper;
import org.junit.jupiter.api.Test;
import org.practice.scheduler.entities.InventoryItem;
import org.practice.scheduler.enums.InventoryOperationType;
import org.practice.scheduler.model.TaskModel;
import org.practice.scheduler.service.InventoryService;
import org.practice.scheduler.service.ThreadService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ThreadServiceTests {
    @Test
    void testCreateTask() throws InterruptedException {
        int numberOfTasks = 1;

        InventoryService inventoryService = new InventoryService();

        ThreadService threadService = new ThreadService(inventoryService);
        ArrayList<TaskModel> generatedTasks = CreateTasksHelper.generateManyTasks(numberOfTasks);

        Map<InventoryItem, Integer> itemsStoredInMemory = threadService.runTasks(generatedTasks);

        for (TaskModel task : generatedTasks) {
            InventoryItem item = task.getInventoryItem();
            int expectedQuantity = task.getQuantity();
            InventoryOperationType op = task.getOperationType();

            switch (op) {
                case ADD -> {
                    assertTrue(itemsStoredInMemory.containsKey(item),
                            "ADD operation failed: item not found in inventory: " + item);
                    assertEquals(expectedQuantity, itemsStoredInMemory.get(item),
                            "ADD operation failed: incorrect quantity for item: " + item);
                }

                case REMOVE -> {
                    assertFalse(itemsStoredInMemory.containsKey(item),
                            "REMOVE operation failed: item should not exist: " + item);
                }

                case UPDATE -> {
                    assertTrue(itemsStoredInMemory.containsKey(item),
                            "UPDATE operation failed: item not found: " + item);
                    assertEquals(expectedQuantity, itemsStoredInMemory.get(item),
                            "UPDATE operation failed: quantity mismatch for item: " + item);
                }
            }
        }
    }

    @Test
    void testCreateManyTasksThatAddRemove() throws InterruptedException {
        int numberOfTasks = 20;

        InventoryService inventoryService = new InventoryService();

        ThreadService threadService = new ThreadService(inventoryService);
        ArrayList<TaskModel> generatedTasks = CreateTasksHelper.generateManyTasks(numberOfTasks);

        Map<InventoryItem, Integer> itemsStoredInMemory = threadService.runTasks(generatedTasks);

        for (TaskModel task : generatedTasks) {
            InventoryItem item = task.getInventoryItem();
            int expectedQuantity = task.getQuantity();
            InventoryOperationType op = task.getOperationType();

            switch (op) {
                case ADD -> {
                    assertTrue(itemsStoredInMemory.containsKey(item),
                            "ADD operation failed: item not found in inventory: " + item);
                    assertEquals(expectedQuantity, itemsStoredInMemory.get(item),
                            "ADD operation failed: incorrect quantity for item: " + item);
                }

                case REMOVE -> {
                    assertFalse(itemsStoredInMemory.containsKey(item),
                            "REMOVE operation failed: item should not exist: " + item);
                }

                case UPDATE -> {
                    assertTrue(itemsStoredInMemory.containsKey(item),
                            "UPDATE operation failed: item not found: " + item);
                    assertEquals(expectedQuantity, itemsStoredInMemory.get(item),
                            "UPDATE operation failed: quantity mismatch for item: " + item);
                }
            }
        }
    }

}
