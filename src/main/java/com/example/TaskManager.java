package com.example;

import java.util.List;

public class TaskManager extends Manager<Task> {

    List<Task> tasks;

    public TaskManager(List<Task> tasks) {
        super(tasks);
    }

}
