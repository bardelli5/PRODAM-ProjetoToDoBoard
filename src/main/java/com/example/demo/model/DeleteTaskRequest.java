package com.example.demo.model;

public class DeleteTaskRequest {
    private String taskId;
    private String todoBoardId;

    public DeleteTaskRequest() {}

    public DeleteTaskRequest(String taskId, String todoBoardId) {
        this.taskId = taskId;
        this.todoBoardId = todoBoardId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTodoBoardId() {
        return todoBoardId;
    }

    public void setTodoBoardId(String todoBoardId) {
        this.todoBoardId = todoBoardId;
    }
}
