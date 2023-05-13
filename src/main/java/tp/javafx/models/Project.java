package models;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String title;
    private List<Task> tasks;

    public Project(String title) {
        this.title = title;
        this.tasks = new ArrayList<>();
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    // Add and remove tasks
    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }
}
