package com.example.dp;

import com.example.Event;
import com.example.SimpleTask;
import com.example.Task;

public class TodoEventConverter extends Converter<Task, Event> {

    public TodoEventConverter() {
        super(TodoEventConverter::convertToEntity, TodoEventConverter::convertToDto);
    }

    private static Task convertToDto(Event user) {
        return convertToDtoWithFactory(user,new SimpleTaskFactory()); 
    }

    private static Task convertToDtoWithFactory(Event user, TaskFactory tf) {
        return tf.createTask( user.getEventname(), user.getDescription());
    }

    private static Event convertToEntity(Task dto) {
        return new Event(dto.taskid(), dto.description(), dto.name(), dto.deadline(), "venue");
    }

}
