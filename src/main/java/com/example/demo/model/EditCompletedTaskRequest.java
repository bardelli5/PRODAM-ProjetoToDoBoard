package com.example.demo.model;

public class EditCompletedTaskRequest {
    private String taskId;

    public EditCompletedTaskRequest() {
    }

    public EditCompletedTaskRequest(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
