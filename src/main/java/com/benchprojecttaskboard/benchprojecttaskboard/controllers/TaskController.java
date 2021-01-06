package com.benchprojecttaskboard.benchprojecttaskboard.controllers;

import com.benchprojecttaskboard.benchprojecttaskboard.models.Task;
import com.benchprojecttaskboard.benchprojecttaskboard.models.User;
import com.benchprojecttaskboard.benchprojecttaskboard.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    public TaskService taskService;

    @GetMapping("/task")
    public List<Task> getUsers(){
        return taskService.getUsers();
    }

    @PostMapping("/task")
    public Task saveTask(@RequestBody Task task){
        taskService.saveTask(task);
        return task;
    }

    @GetMapping("/task/{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }


}
