package controller;

import org.junit.jupiter.api.Test;
import org.practice.scheduler.controller.TaskController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = {TaskController.class})
@WebMvcTest(TaskController.class)
public class TaskControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnInventoryItems() throws Exception {
        String taskJson = "[{\"operationType\":\"ADD\", \"quantity\":3, \"item\":{\"name\":\"Hammer\", \"category\":\"Tools\"}}]";

        mockMvc.perform(post("/tasks")
                        .content(taskJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
