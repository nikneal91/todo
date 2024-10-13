package com.example.dp;

import java.time.LocalDate;

import com.example.SimpleTask;
import com.example.Task;

public class SimpleTaskFactory  implements TaskFactory{

    private static int taskCount = 0;


   public Task createTask(String name, String description) {
        taskCount++;
        return new SimpleTask(taskCount, name, description, LocalDate.now().plusDays(5), "simple");
    }
}


