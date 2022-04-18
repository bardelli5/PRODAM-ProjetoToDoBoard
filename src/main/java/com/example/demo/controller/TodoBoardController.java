package com.example.demo.controller;

import com.example.demo.entities.TodoBoard;
import com.example.demo.model.DeleteTaskRequest;
import com.example.demo.model.EditCompletedTaskRequest;
import com.example.demo.model.EditTaskTitleRequest;
import com.example.demo.model.NewTaskRequest;
import com.example.demo.services.TodoBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoBoardController {
    @Autowired
    private TodoBoardService todoBoardService;

    @PostMapping("/todoboard/{todoboard_id}")
    public ModelAndView addTask(
            @PathVariable(name="todoboard_id") String todoBoardId,
            @RequestBody NewTaskRequest newTaskRequest
    ){
        ModelAndView model = new ModelAndView("todoBoard::task_list");
        TodoBoard todoBoard = todoBoardService.addTask(todoBoardId, newTaskRequest);

        model.addObject("todoBoard", todoBoard);
        return model;
    }

    @DeleteMapping("/todoboard/deleteTask/")
    public ModelAndView deleteTask(@RequestBody DeleteTaskRequest deleteTaskRequest) {
        ModelAndView model = new ModelAndView("todoBoard::task_list");
        TodoBoard todoBoard = todoBoardService.deleteTask(deleteTaskRequest);
        model.addObject("todoBoard", todoBoard);
        return model;
    }

    @PutMapping("/todoboard/completedTask/")
    public ResponseEntity<?> completedTask(@RequestBody EditCompletedTaskRequest editCompletedTaskRequest) {
        todoBoardService.editCompleted(editCompletedTaskRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/todoboard/editedTaskTitle")
    public ModelAndView editedTask(@RequestBody EditTaskTitleRequest editTaskTitleRequest){
        ModelAndView model = new ModelAndView("todoBoard::task_list");
        TodoBoard updatedTask = todoBoardService.editTaskTitle(editTaskTitleRequest);
        model.addObject(updatedTask);
        return model;
    }

}
