package com.app.todo.controller;

import com.app.todo.models.TaskEntity;
import com.app.todo.services.TodoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/tasks")
@Controller
public class TaskController {
    @Autowired
    private TodoServiceInterface todoServiceInterface;

    @GetMapping
    public String getTask (Model model) {
        List<TaskEntity> task = todoServiceInterface.getAllTask();
        model.addAttribute("tasks", task);
        return "tasks";
    }

    @PostMapping
    public String createTask (@RequestParam String title) {
        todoServiceInterface.createTask(title);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        todoServiceInterface.deleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        todoServiceInterface.toggleTask(id);
        return "redirect:/tasks";
    }
}
