package com.example;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Task extends Printable,Comparable<Task> {

    public static Logger log = LoggerFactory.getLogger(Task.class);

    public LocalDate deadline();
    public int taskid();
    public String description();
    public String name();

 
   default public void print() {
        log.info(toString());
    }

    @Override
    default public int compareTo(Task o) {
        return this.deadline().compareTo(o.deadline());
    }

}