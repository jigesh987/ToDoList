package com.todoapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapp.entity.Task;
import com.todoapp.entity.User;
import com.todoapp.repositories.TaskRepo;
import com.todoapp.repositories.UserRepo;

@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private UserRepo userRepo;
    
    

    // Add Task
    public String addTask(Long userId, Task task) {
       Optional<User> user=userRepo.findById(userId);
        if(user.isEmpty()) {
        	return " no user found";
        }
        User new_user=user.get();
        task.setUser(new_user);
        taskRepo.save(task);
        return "Task added successfully for user"+userId;
        
    }

    // Get All Tasks for a User
    public List<Task> getTaskByUserId(Long userId) {
        return taskRepo.findByUserId(userId);
    }

    
}






