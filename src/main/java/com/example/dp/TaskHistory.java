package com.example.dp;

import java.util.Stack;

import com.example.TaskManager;

// The Caretaker
public class TaskHistory {
    private final Stack<TaskMemento> undoStack = new Stack<>();
    private final Stack<TaskMemento> redoStack = new Stack<>();

    // Save the current state for undo
    public void saveState(TaskManager manager) {
        undoStack.push(manager.save());
        System.out.println("Catching null pointer");
        if ( !redoStack.isEmpty())
            redoStack.clear(); // Clear the redo stack when a new action is performed
    }

    // Undo the last action
    public void undo(TaskManager manager) {
        if (!undoStack.isEmpty()) {
            redoStack.push(manager.save());
            TaskMemento memento = undoStack.pop();
            manager.restore(memento);
        } else {
            System.out.println("Nothing to undo!");
        }
    }

    // Redo the last undone action
    public void redo(TaskManager manager) {
        if (!redoStack.isEmpty()) {
            undoStack.push(manager.save());
            TaskMemento memento = redoStack.pop();
            manager.restore(memento);
        } else {
            System.out.println("Nothing to redo!");
        }
    }
}
