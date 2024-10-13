package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.slf4j.*;

import com.example.dp.TodoEventConverter;

/**
 * A simple ToDo App
 *
 */
public class App 
{

    private static Logger log = LoggerFactory.getLogger(App.class);

    private static Supplier<List<Task>> taskSupplier = () -> {   
        Task t1 = new Task(1, "Task1", "Task1 Description", LocalDate.now());
        Task t2 = new Task(2, "Task2", "Task2 Description", LocalDate.now());
        Task t3 = new Task(3, "Task3", "Task3 Description", LocalDate.now());
        Task t4 = new Task(4, "Task4", "Task4 Description", LocalDate.of(2025, 1, 1)); // Future date
        Task t5 = new Task(5, "Task5", "Task5 Description", LocalDate.of(2023, 12, 25)); // Future date
        Task t6 = new Task(6, "Task6", "Task6 Description", LocalDate.of(2020, 5, 15)); // Past date
        Task t7 = new Task(7, "Task7", "Task7 Description", LocalDate.of(2019, 8, 20)); // Past date
        List<Task> tasks = List.of(t1,t2,t3,t4,t5,t6,t7);
        return tasks;
        };
    

    private static void events() {

    }


    public static void main( String[] args )
    {
        MDC.put("author", "Nikhil");
        log.info("This is a test log");
        TaskManager taskManager = new TaskManager(taskSupplier.get());
        Callback c = ()-> System.out.println("Printed task details done");
        Optional<Callback> cof = Optional.of(c);
        taskManager.printDetails(cof);

        Task dummyTask = new Task(0, "Dummy", "Dummy", LocalDate.now());
        log.debug("Old Tasks");
        taskManager.getOldTasks(dummyTask).forEach(t -> System.out.println(t.name() + " " + t.deadline()));
        log.debug("Pending Tasks");
        taskManager.getPendingTasks(dummyTask).forEach(t -> System.out.println(t.name()  + " " + t.deadline() ));

        Event e1 = new Event(1, "Event1", "Event1 Description", LocalDate.now(), "Event1 Venue");
        Event e2 = new Event(2, "Event2", "Event2 Description", LocalDate.now(), "Event2 Venue");
        Event e3 = new Event(3, "Event3", "Event3 Description", LocalDate.now(), "Event3 Venue");
        TodoEventConverter conv = new TodoEventConverter();
        Event e4 = conv.convertFromDto(dummyTask);
        EventManager manager = new EventManager(Arrays.asList(new Event[]{e1, e2, e3, e4}));
        MDC.put("App", "Console");
        manager.printDetails(cof);
    }
}
