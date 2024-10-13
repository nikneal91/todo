package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

import org.slf4j.*;

import com.example.dp.ComplexTaskFactory;
import com.example.dp.SimpleTaskFactory;
import com.example.dp.TaskFactory;
import com.example.dp.TaskHistory;
import com.example.dp.TodoEventConverter;
import com.example.dp.Utility;

/**
 * A simple ToDo App
 *
 */
public class App {

    private static final String DEFAULT_URL = "https://raw.githubusercontent.com/iluwatar/java-design-patterns/master/promise/README.md";
    private final ExecutorService executor;

    private static Logger log = LoggerFactory.getLogger(App.class);


    
    private App() {
        // Create a thread pool with 2 threads
        executor = Executors.newFixedThreadPool(2);
    }

    private static Supplier<List<Task>> taskSupplier = () -> {
        TaskFactory tf = new SimpleTaskFactory();
        Task t1 = tf.createTask("Task1", "Task1 Description");
        Task t2 = tf.createTask("Task2", "Task2 Description");
        Task t3 = tf.createTask("Task3", "Task3 Description");
        Task t4 = tf.createTask("Task4", "Task4 Description"); // Future date
        Task t5 = tf.createTask("Task5", "Task5 Description"); // Future date
        Task t6 = tf.createTask("Task6", "Task6 Description"); // Past date
        Task t7 = tf.createTask("Task7", "Task7 Description"); // Past date
        List<Task> tasks = Arrays.asList(t1, t2, t3, t4, t5, t6, t7);
        List<Task> modifiableList = new ArrayList<>(tasks);
        return modifiableList;
    };

    private static Supplier<List<Event>> eventsSyoSupplier = () -> {
        TaskFactory tf = new SimpleTaskFactory();
        Event e1 = new Event(1, "Event1", "Event1 Description", LocalDate.now(), "Event1 Venue");
        Event e2 = new Event(2, "Event2", "Event2 Description", LocalDate.now(), "Event2 Venue");
        Event e3 = new Event(3, "Event3", "Event3 Description", LocalDate.now(), "Event3 Venue");
        Task dummyTask = tf.createTask("Dummy", "Dummy");

        TodoEventConverter conv = new TodoEventConverter();
        Event e4 = conv.convertFromDto(dummyTask);
        List<Event> fixedList = List.of(e1, e2, e3, e4);
        List<Event> modifiableList = new ArrayList<Event>(fixedList);
        return modifiableList;
    };

    public static void main(String[] args) {
        MDC.put("author", "Nikhil");
        log.info("This is a test log");
        TaskManager taskManager = new TaskManager(taskSupplier.get());
        Callback c = () -> System.out.println("Printed task details done");
        Optional<Callback> cof = Optional.of(c);
        taskManager.printDetails(cof);

        TaskFactory stf = new SimpleTaskFactory();

        ComplexTask dummyTask = new ComplexTask(101, "Dummy", "Dummy", LocalDate.now(), "complex");
        Task subTas1 = stf.createTask("subtask-one", "subtask for complex dummy taks");
        Task subTas2 = stf.createTask("subtask-two", "subtask for complex dummy taks");
        dummyTask.addSubTask(subTas1);
        dummyTask.addSubTask(subTas2);

        log.debug("Old Tasks");
        taskManager.getOldTasks(dummyTask).forEach(t -> System.out.println(t.name() + " " + t.deadline()));
        log.debug("Pending Tasks");
        taskManager.getPendingTasks(dummyTask).forEach(t -> System.out.println(t.name() + " " + t.deadline()));

        EventManager manager = new EventManager(eventsSyoSupplier.get());

        MDC.put("App", "Console");
        manager.printDetails(cof);

        System.out.println("Momento Design Pattern implementation below :-");
        taskManager.printDetails(null);
        TaskHistory history = new TaskHistory();
        history.saveState(taskManager);
        System.out.println("Current To-Do List: " + taskManager.getSize());
        taskManager.addTask(dummyTask);
        System.out.println("==========================================================");
        taskManager.printDetails(cof);
        System.out.println("==========================================================");
        System.out.println("Current To-Do List: " + taskManager.getSize());
        history.undo(taskManager);
        System.out.println("New To-Do List: " + taskManager.getSize());
        history.redo(taskManager);
        System.out.println("New To-Do List: " + taskManager.getSize());

        log.info("Practise of Factory design pattern");
        Utility.printLine();
        log.info("Promise design patern implemention");
        Utility.printLine();

            var app = new App();
            app.promiseUsage();
          
        
          

    }
}
