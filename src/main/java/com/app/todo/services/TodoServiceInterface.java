package com.app.todo.services;

import com.app.todo.models.TaskEntity;

import java.util.List;

public interface TodoServiceInterface {
    List<TaskEntity> getAllTask();

    void createTask(String title);

    void deleteTask(Long id);

    void toggleTask(Long id);
}
