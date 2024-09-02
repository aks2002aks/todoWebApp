package com.ashwani.todowebapp.controller;

import com.ashwani.todowebapp.model.Todo;
import com.ashwani.todowebapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping(value = "/addTodo", consumes = "application/json", produces = "application/json")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodos(todo);
    }

    @GetMapping(value = "/getAllTodos", produces = "application/json")
    public Iterable<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping(value = "/getTodo/{id}", produces = "application/json")
    public Todo getTodoById(@PathVariable String id) {
        return todoService.getTodoById(id);
    }

    @DeleteMapping(value = "/deleteTodo/{id}")
    public void deleteTodoById(@PathVariable String id) {
        todoService.deleteTodoById(id);
    }

    @PutMapping(value = "/updateTodo/{id}", consumes = "application/json", produces = "application/json")
    public Todo updateTodoById(@PathVariable String id, @RequestBody Todo todo) {
        return todoService.updateTodoById(id, todo);
    }
}
