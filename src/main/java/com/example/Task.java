package com.example;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public record Task(int taskid,String name,String description,LocalDate deadline) 
implements Printable,Comparable<Task> {

    private static Logger log = LoggerFactory.getLogger(Task.class);

    @Override
    public String toString() {
        return "Task [taskid=" + taskid + ", name=" + name + ", description=" + description + ", deadline=" + deadline
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