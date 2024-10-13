package com.example.dp;

import com.example.Event;
import com.example.Task;

public class TodoEventConverter extends Converter<Task, Event> {

    public TodoEventConverter() {
        super(TodoEventConverter::convertToEntity, TodoEventConverter::convertToDto);
    }

    private static Task convertToDto(Event user) {
        return new Task(user.getEventid(), user.getEventname(), user.getDescription(), user.getEventDate());
    }

    private static Event convertToEntity(Task dto) {
        return new Event(dto.taskid(), dto.description(), dto.name(), dto.deadline(), "venue");
    }

}
