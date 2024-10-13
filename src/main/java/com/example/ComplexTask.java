package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class ComplexTask extends AbstractTask implements Printable,Comparable<Task>,Task {

    public ComplexTask(int taskid, String name, String description , LocalDate deadline ,String type) {
        super(taskid,name,description,deadline);
        this.type =type;
    }


    String type; 


    private static Logger log = LoggerFactory.getLogger(Task.class);
    private List<Task> subTasks= new ArrayList<>();

    

     // Method to add a sub-task
    public void addSubTask(Task task) {
        subTasks.add(task);
    }

    // Method to remove a sub-task
    public void removeSubTask(Task task) {
        subTasks.remove(task);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Task t : subTasks) {
            sb.append(t.toString());
        }

        return "ComplexTask [taskid=" + taskid + ", name=" + name + ", description=" + description + ", deadline=" + deadline
                + "]" + "\n" + "Subtasks " + sb.toString();
    }


    


    public void print() {
        log.info(toString());
    }

    @Override
    public int compareTo(Task o) {
        return this.deadline().compareTo(o.deadline());
    }


}