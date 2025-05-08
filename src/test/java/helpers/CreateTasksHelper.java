package helpers;

import org.practice.scheduler.entities.InventoryItem;
import org.practice.scheduler.enums.InventoryOperationType;
import org.practice.scheduler.model.TaskModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateTasksHelper {

    private static final List<String> ITEM_NAMES = List.of(
            "Apple", "Cheddar", "Salmon", "Chicken", "Tofu", "Pasta", "Avocado",
            "Steak", "Rice", "Yogurt", "Mushroom", "Lentils", "Tomato", "Broccoli"
    );

    private static final List<String> ITEM_TYPES = List.of(
            "Fruit", "Vegetable", "Meat", "Dairy", "Grain", "Legume", "Seafood", "Plant-based"
    );

    private static final InventoryOperationType[] OPERATIONS = InventoryOperationType.values();
    private static final Random random = new Random();

    public static ArrayList<TaskModel> generateManyTasks(int count) {
        ArrayList<TaskModel> tasks = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            // don't like this but it works for now, thanks chatgpt. it just creates a uid by wrapping the integer around to the start
            // todo: change to a more realistic test builder
            String baseName = ITEM_NAMES.get(i % ITEM_NAMES.size());
            String itemName = baseName + "_Item_" + i;

            String itemType = ITEM_TYPES.get(i % ITEM_TYPES.size());
            InventoryItem item = new InventoryItem(itemName, itemType);

            int quantity = random.nextInt(100);
            InventoryOperationType operation = OPERATIONS[random.nextInt(OPERATIONS.length)];

            TaskModel task = new TaskModel();
            task.setInventoryItem(item);
            task.setOperationType(operation);
            task.setQuantity(quantity);

            tasks.add(task);
        }

        return tasks;
    }

}
