# ToDo and Event Management App

This project is a test project to create a ToDo app and an Event app using generics. The goal is to use a single manager class to handle both events and tasks efficiently.

## Features

- Manage tasks with deadlines.
- Manage events with descriptions and venues.
- Use a single manager class to handle both tasks and events.
- Print details of tasks and events.
- Filter old and pending tasks.

## Project Structure

- `App.java`: The main class that demonstrates the functionality of the ToDo and Event management system.
- `Task.java`: Represents a task with an ID, name, description, and deadline.
- `Event.java`: Represents an event with an ID, name, description, date, and venue.
- `Manager.java`: A generic manager class that can handle both tasks and events.
- `TaskManager.java`: Extends the `Manager` class to provide specific functionalities for tasks.
- `EventManager.java`: Extends the `Manager` class to provide specific functionalities for events.

## Usage

### Running the Application

To run the application, use the following Maven command:

```sh
mvn clean package
java -jar target/my-app-1.0-SNAPSHOT-jar-with-dependencies.jar


Read https://www.slf4j.org/manual.html#projectDep for logging setup 
