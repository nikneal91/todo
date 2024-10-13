package com.example;

import java.util.List;
import java.util.Optional;



import java.util.ArrayList;
import java.lang.Comparable;

public class Manager<T extends Printable & Comparable<T>> {

    List<T> tasks;
    
    public Manager(List<T> tasks) {
        this.tasks = tasks;
    }

    public void printDetails(Optional<Callback> call) {
        for ( T t : tasks) {
            t.print();
        }
        if ( call.isPresent()) {
            call.get().callback();
        }

    }
    
    public List<T> filter(T other, boolean isOld) {
        List<T> result = new ArrayList<>();
        for ( T t : tasks) {
            if (isOld && t.compareTo(other) > 0) {
                result.add(t);                
            } 
 
            if ( !isOld && t.compareTo(other) < 0) {
                result.add(t);                
            }
        }
        return result;
    }


    public List<T> getOldTasks(T other) {
        return filter(other, true);
    }

    public List<T> getPendingTasks(T other) {
        return filter(other, false);
    }

}
