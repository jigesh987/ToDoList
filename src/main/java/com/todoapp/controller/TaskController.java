package com.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todoapp.entity.Task;
import com.todoapp.services.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;
    

    @PostMapping("/addTask")
    public String addTask(@RequestParam Long userid,@RequestBody Task task) {
    	return taskService.addTask(userid, task);
    }

   
    @GetMapping("/user/{userId}")
    public List<Task> getTask(@PathVariable Long userId) {
        List<Task> task= taskService.getTaskByUserId(userId);
        return task;
    }


}

