package com.example.demo.repositories;

import com.example.demo.entities.Task;
import com.example.demo.entities.TodoBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, String> {
    List<Task> findByTodoBoard(TodoBoard todoBoard);
}
