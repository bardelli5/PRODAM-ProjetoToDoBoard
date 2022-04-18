package com.example.demo.repositories;

import com.example.demo.entities.TodoBoard;
import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TodoBoardRepository extends JpaRepository<TodoBoard, String> {
    TodoBoard findByUser(User user);
}
