package models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;

    private List<Project> projects;
    private List<Task> tasks;

    public User(String username, String password) {
        this.username = username;
        this.projects = new ArrayList<>();
        this.tasks = new ArrayList<>();
    }

    // getters and setters for username and password

    public List<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }

    public void removeProject(Project project) {
        this.projects.remove(project);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void removeTask(Task task) {
        this.tasks.remove(task);
    }
}