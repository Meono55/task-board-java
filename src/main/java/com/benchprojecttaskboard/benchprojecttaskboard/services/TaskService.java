package com.benchprojecttaskboard.benchprojecttaskboard.services;

import com.benchprojecttaskboard.benchprojecttaskboard.models.Task;
import com.benchprojecttaskboard.benchprojecttaskboard.models.User;
import com.benchprojecttaskboard.benchprojecttaskboard.repositories.TaskRepository;
import com.benchprojecttaskboard.benchprojecttaskboard.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {


    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getUsers(){
        return taskRepository.findAll();
    }

    public void saveTask(Task task){
        taskRepository.save(task);
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id).get();
    }
}
