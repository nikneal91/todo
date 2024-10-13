package com.example;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.dp.TaskMemento;


public class TaskManager extends Manager<Task> {

    private static Logger log = LoggerFactory.getLogger(TaskManager.class);
    

    public TaskManager(List<Task> tasks) {
        super(tasks);
    }

    public void addTask(Task t) {
        System.out.println("Adding task " + t.toString());
        tasks.add(t);
    }

     // Create a new TaskMemento (snapshot of the current state)
    public TaskMemento save() {
        log.info("task saved " + this.tasks.size());
        return new TaskMemento(new ArrayList<>(this.tasks));
    }

    // Restore the ToDoList state from the TaskMemento
    public void restore(TaskMemento memento) {
        tasks = memento.getSavedTasks();
    }

}
