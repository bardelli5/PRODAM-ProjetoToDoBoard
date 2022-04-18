package com.example.demo.services;

import com.example.demo.entities.Task;
import com.example.demo.entities.TodoBoard;
import com.example.demo.model.DeleteTaskRequest;
import com.example.demo.model.EditCompletedTaskRequest;
import com.example.demo.model.EditTaskTitleRequest;
import com.example.demo.model.NewTaskRequest;
import com.example.demo.repositories.TaskRepository;
import com.example.demo.repositories.TodoBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoBoardService {
    @Autowired
    private TodoBoardRepository todoBoardRepository;
    @Autowired
    private TaskRepository taskRepository;

    public TodoBoard addTask(String todoBoardId, NewTaskRequest newTaskRequest){
        TodoBoard todoBoard = todoBoardRepository.findById(todoBoardId).orElseThrow();
        Task task = new Task(UUID.randomUUID().toString(), todoBoard, newTaskRequest);

        taskRepository.save(task);
        List<Task> taskList = taskRepository.findByTodoBoard(todoBoard);
        todoBoard.setTasks(taskList);
        return todoBoard;
    }

    public TodoBoard deleteTask(DeleteTaskRequest deleteTaskRequest){
        TodoBoard todoBoard = todoBoardRepository.findById(deleteTaskRequest.getTodoBoardId()).orElseThrow();

        taskRepository.deleteById(deleteTaskRequest.getTaskId());
        List<Task> taskList = taskRepository.findByTodoBoard(todoBoard);
        todoBoard.setTasks(taskList);
        return todoBoard;
    }

    public void editCompleted(EditCompletedTaskRequest editCompletedTaskRequest){
        Task task = taskRepository.findById(editCompletedTaskRequest.getTaskId()).orElseThrow();
        task.setCompleted();
        taskRepository.save(task);
    }

    public TodoBoard editTaskTitle(EditTaskTitleRequest editTaskTitleRequest){
        TodoBoard todoBoard = todoBoardRepository.findById(editTaskTitleRequest.getTodoBoardId()).orElseThrow();
        Task task = taskRepository.findById(editTaskTitleRequest.getTaskId()).orElseThrow();
        task.setTask(editTaskTitleRequest.getTitle());
        taskRepository.save(task);
        List<Task> taskList = taskRepository.findByTodoBoard(todoBoard);
        todoBoard.setTasks(taskList);
        return todoBoard;
    }
}
