package com.app.todo.services;

import com.app.todo.models.TaskEntity;
import com.app.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService implements TodoServiceInterface{

    @Autowired
    private  TaskRepository taskRepository;

    public List<TaskEntity> getAllTask() {
        return taskRepository.findAll();
    }
    public void createTask(String title) {
        TaskEntity task = new TaskEntity();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void toggleTask(Long id) {
        TaskEntity toggleTaskObj = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task dont found"));
        toggleTaskObj.setCompleted(!toggleTaskObj.isCompleted());
        taskRepository.save(toggleTaskObj);
    }

}
