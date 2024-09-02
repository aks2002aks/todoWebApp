package com.ashwani.todowebapp.service;

import com.ashwani.todowebapp.model.Todo;
import com.ashwani.todowebapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepo;

    public Iterable<Todo> getAllTodos() {
        return todoRepo.findAll();
    }

    public Todo addTodos(Todo todo) {
        todo.setDone(false); // Ensure done is always
        todoRepo.save(todo);
        return todo;
    }

    public Todo getTodoById(String id) {
        return todoRepo.findById(id).orElse(null);
    }

    public void deleteTodoById(String id) {
        Todo todoToUpdate = todoRepo.findById(id).orElse(null);
        if (todoToUpdate != null) {
            todoToUpdate.setDeletedAt(new Date().toString());
            todoRepo.save(todoToUpdate);
        }
    }

    public Todo updateTodoById(String id, Todo todo) {
        Todo todoToUpdate = todoRepo.findById(id).orElse(null);
        if (todoToUpdate != null) {
            todoToUpdate.setTitle(todo.getTitle());
            todoToUpdate.setDescription(todo.getDescription());
            todoToUpdate.setDone(todo.isDone());
            todoRepo.save(todoToUpdate);
        }
        return todoToUpdate;
    }
}
