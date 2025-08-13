package com.marrahenzo.proyecto.task.model;

import com.marrahenzo.proyecto.task.exception.TaskException;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    List<Task> tasks = new ArrayList<>();

    public void save(Task task) throws TaskException {
        if(task == null)
            throw new TaskException("The provided task is null");

        this.tasks.add(task);
    }

    public Task findById(String id) {
        for(Task task: tasks) {
            if(task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }

    public void remove(String id) throws TaskException {
        Task task = this.findById(id);
        if(task == null)
            throw new TaskException("The provided task is null");

        this.tasks.remove(task);
    }

    public void remove(Task task) throws TaskException {
        if(task == null)
            throw new TaskException("The provided task is null");

        if(!tasks.contains(task))
            throw new TaskException("The provided task is not in the task list");

        this.tasks.remove(task);
    }

    public List<Task> findAll() throws TaskException {
        if(tasks.isEmpty())
            throw new TaskException("The task list is empty");

        return this.tasks;
    }

    public Integer findIndexById(String id) {
        for(int i = 0; i < this.tasks.size(); i++) {
            if(tasks.get(i).getId().equals(id))
                return i;
        }
        return -1;
    }

    public void updateTask(Task updatedTask) throws TaskException {
        if(!tasks.contains(updatedTask))
            throw new TaskException("The provided task is not in the task list");

        int index = this.findIndexById(updatedTask.getId());
        if(index == -1)
            throw new TaskException("The provided task is not in the task list");

        tasks.set(index, updatedTask);
    }
}
