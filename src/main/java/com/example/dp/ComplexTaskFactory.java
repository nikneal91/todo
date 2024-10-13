package com.example.dp;

import java.time.LocalDate;

import com.example.ComplexTask;
import com.example.Task;

public class ComplexTaskFactory implements TaskFactory {
    
   public  Task createTask(String name, String description) {
        return new ComplexTask(0, name, description, LocalDate.now().plusDays(5), "complex");
    }

   
}


