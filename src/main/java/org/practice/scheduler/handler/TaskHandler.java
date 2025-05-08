package org.practice.scheduler.handler;

import org.practice.scheduler.model.TaskModel;
import org.practice.scheduler.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskHandler {


    private final ThreadService threadService;

    @Autowired
    public TaskHandler(ThreadService threadService){
        this.threadService = threadService;
    }

    public void createTasksToRun(List<TaskModel> tasks) throws InterruptedException {
        threadService.runTasks(tasks);
    }
}
