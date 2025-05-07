package service;

import org.junit.jupiter.api.Test;
import org.practice.scheduler.entities.InventoryItem;
import org.practice.scheduler.service.InventoryService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class InventoryServiceTests {
    @Test
    void testWhenAddInventory(){
        int quantity = 3;
        InventoryItem item = new InventoryItem("Bbq Shapes", "Crackers");

        InventoryService service = new InventoryService();

        service.addStock(item,quantity);
        Map<InventoryItem, Integer> resultMap = new HashMap<>(service.getAllItems());

        assertEquals(quantity, resultMap.get(item));
    }

    @Test
    void testWhenRemoveInventory(){
        int quantity = 3;
        InventoryItem item = new InventoryItem("Bbq Shapes", "Crackers");

        InventoryService service = new InventoryService();

        service.addStock(item,quantity);
        service.removeStock(item);

        Map<InventoryItem, Integer> resultMap = new HashMap<>(service.getAllItems());

        assertNull(resultMap.get(item));
    }

    @Test
    void testWhenUpdateInventory(){
        int quantity = 3;
        int quantityToAdd = 5;

        int totalNewQuantity = 8;

        InventoryItem item = new InventoryItem("Bbq Shapes", "Crackers");

        InventoryService service = new InventoryService();

        service.addStock(item,quantity);
        service.updateStock(item,quantityToAdd);

        Map<InventoryItem, Integer> resultMap = new HashMap<>(service.getAllItems());

        assertEquals(totalNewQuantity, resultMap.get(item));
    }

    @Test
    void testWhenUpdateInventoryAndTotalQuantityIsReduced(){
        int quantity = 8;
        int quantityToRemove = -3;

        int totalNewQuantity = 5;

        InventoryItem item = new InventoryItem("Bbq Shapes", "Crackers");

        InventoryService service = new InventoryService();

        service.addStock(item,quantity);
        service.updateStock(item,quantityToRemove);

        Map<InventoryItem, Integer> resultMap = new HashMap<>(service.getAllItems());

        assertEquals(totalNewQuantity, resultMap.get(item));
    }

    @Test
    void testWhenUpdateInventoryAndTotalQuantityIsReducedAndIsNegative(){
        int quantity = 500;
        int quantityToRemove = -10000;

        int totalNewQuantity = 0;

        InventoryItem item = new InventoryItem("Bbq Shapes", "Crackers");

        InventoryService service = new InventoryService();

        service.addStock(item,quantity);
        service.updateStock(item,quantityToRemove);

        Map<InventoryItem, Integer> resultMap = new HashMap<>(service.getAllItems());

        assertEquals(totalNewQuantity, resultMap.get(item));
    }

}
