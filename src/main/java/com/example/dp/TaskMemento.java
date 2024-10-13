package com.example.dp;

import java.util.ArrayList;
import java.util.List;

import com.example.Task;

public class TaskMemento {
    private  List<Task> tasks = new ArrayList<>();

    public TaskMemento(List<Task> tasks) {
        System.out.println("getting tasks" + tasks.size());
        this.tasks = tasks;
    }

    // Returns the saved tasks
    public List<Task> getSavedTasks() {
        return tasks;
    }
}
