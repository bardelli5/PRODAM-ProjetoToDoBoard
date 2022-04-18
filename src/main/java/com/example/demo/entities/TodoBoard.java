package com.example.demo.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class TodoBoard {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    private List<Task> tasks;

    public TodoBoard() { }

    public TodoBoard(String id, User user, List<Task> tasks) {
        this.id = id;
        this.user = user;
        this.tasks = tasks;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void deleteTask(Task task){
        this.tasks.remove(task);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
