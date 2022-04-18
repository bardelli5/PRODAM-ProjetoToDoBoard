package com.example.demo.entities;

import com.example.demo.model.DeleteTaskRequest;
import com.example.demo.model.NewTaskRequest;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Task {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @ManyToOne
    @JoinColumn(name = "todo_id")
    private TodoBoard todoBoard;

    private boolean completed;

    private String task;

    public Task() {}

    public Task(String id, TodoBoard todoBoard, boolean completed, String task) {
        this.id = id;
        this.todoBoard = todoBoard;
        this.completed = completed;
        this.task = task;
    }

    public Task(String id, TodoBoard todoBoard, NewTaskRequest newTaskRequest) {
        this.id = id;
        this.todoBoard = todoBoard;
        this.task = newTaskRequest.getTitle();
        this.completed = newTaskRequest.isCompleted();
    }

    public String getId() {
        return id;
    }

    public TodoBoard getTodo() {
        return todoBoard;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getTask() {
        return task;
    }

    public void setCompleted() {
        this.completed = !this.completed;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
