package controller;

import org.junit.jupiter.api.Test;
import org.practice.scheduler.controller.InventoryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = {InventoryController.class})
@WebMvcTest(InventoryController.class)
public class InventoryControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnInventoryItemsWHenAddingTasks() throws Exception {
        mockMvc.perform(get("/inventory")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
