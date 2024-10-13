package com.example;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AbstractTask implements Task{

    int taskid;
    String name;
    String description;
    LocalDate deadline;

    @Override
    public LocalDate deadline() {
        return this.deadline;    
    }

    @Override
    public int taskid() {
        return this .taskid;
    }

    @Override
    public String description() {
        return this.description;
    }

    @Override
    public String name() {
        return this.name;
    }


}
