package com.example;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.AllArgsConstructor;
import lombok.Data;


public class SimpleTask extends AbstractTask implements Printable,Comparable<Task>,Task {

    public SimpleTask(int taskid, String name, String description , LocalDate deadline ,String type) {
        super(taskid,name,description,deadline);
        this.type =type;
    }


    String type;

    private static Logger log = LoggerFactory.getLogger(Task.class);

    @Override
    public String toString() {
        return "Simple-Task [taskid=" + taskid + ", name=" + name + ", description=" + description + ", deadline=" + deadline
                + "]";
    }

    public void print() {
        log.info(toString());
    }

    @Override
    public int compareTo(Task o) {
        return this.deadline().compareTo(o.deadline());
    }

}