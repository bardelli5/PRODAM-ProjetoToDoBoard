package com.example.demo.services;

import com.example.demo.entities.Task;
import com.example.demo.entities.TodoBoard;
import com.example.demo.entities.User;
import com.example.demo.repositories.TaskRepository;
import com.example.demo.repositories.TodoBoardRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TodoBoardRepository todoBoardRepository;
    @Autowired
    private AuthenticationService authenticationService;

    public ModelAndView createNewUser(User user) {
        String hashedPassword = authenticationService.hashPassword(user.getPassword());

        user.setId(UUID.randomUUID().toString());
        user.setPassword(hashedPassword);
        User newUser = userRepository.save(user);

        TodoBoard todoBoard = todoBoardRepository.save(
                new TodoBoard(UUID.randomUUID().toString(), newUser, new ArrayList<>()));

        ModelAndView model = new ModelAndView("todoBoard.html");
        model.addObject("todoBoard", todoBoard);

        return model;
    }

    public ModelAndView validateLogin(User user) {
        Optional<User> possibleUser = userRepository.findByUsername(user.getUsername());

        // Se usuário não existir, retornar página de login inválido
        if(possibleUser.isEmpty()) {
            ModelAndView model = new ModelAndView("loginInvalido.html");
            model.addObject("user", user);
            return model;
        }

        // Se o usuário existir, verifica se a senha está correta e retorna página do TodoBoard
        if(authenticationService.verifyHash(user.getPassword(), possibleUser.get().getPassword())) {
            ModelAndView model = new ModelAndView("todoBoard.html");
            user = possibleUser.get();
            model.addObject("user", user);

            TodoBoard todoBoard = todoBoardRepository.findByUser(user);

            List<Task> tasks = taskRepository.findByTodoBoard(todoBoard);
            todoBoard.setTasks(tasks);

            model.addObject("todoBoard", todoBoard);

            return model;
        }

        ModelAndView model = new ModelAndView("login.html");
        model.addObject("isPasswordIncorrect", true);
        return model;
    }
}
