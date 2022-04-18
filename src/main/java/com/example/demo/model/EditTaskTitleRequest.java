package com.example.demo.model;

public class EditTaskTitleRequest {
    private String taskId;
    private String title;
    private String todoBoardId;

    public EditTaskTitleRequest() {
    }

    public EditTaskTitleRequest(String taskId, String title, String todoBoardId) {
        this.taskId = taskId;
        this.title = title;
        this.todoBoardId = todoBoardId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTodoBoardId() {
        return todoBoardId;
    }

    public void setTodoBoardId(String todoBoardId) {
        this.todoBoardId = todoBoardId;
    }
}
