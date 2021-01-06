package com.benchprojecttaskboard.benchprojecttaskboard.config;

import com.benchprojecttaskboard.benchprojecttaskboard.models.Role;
import com.benchprojecttaskboard.benchprojecttaskboard.models.Task;
import com.benchprojecttaskboard.benchprojecttaskboard.models.TaskStatus;
import com.benchprojecttaskboard.benchprojecttaskboard.models.User;
import com.benchprojecttaskboard.benchprojecttaskboard.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseLoader  implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public DatabaseLoader(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        User newUser = new User();
        newUser.setUserRole(Role.DEVELOPER);
        newUser.setFirstName("Jose");
        newUser.setLastName("Meono");

        Task newTask = new Task();
        newTask.setCurrentStatus(TaskStatus.NEW);
        newTask.setTaskTitle("Test");
        newTask.setUser(newUser);
        newTask.setDescription("Test Description");
        List<Task> listOfTasks = new ArrayList<>();
        listOfTasks.add(newTask);

        newUser.setTasks(listOfTasks);
        this.userRepository.save(newUser);
    }
}
