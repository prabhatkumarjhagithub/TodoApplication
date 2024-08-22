package com.example.TodoApplication.Controller;

//import com.example.todoapp.model.Todo;
//import com.example.todoapp.service.TodoService;
import com.example.TodoApplication.Model.Todo;
import com.example.TodoApplication.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo createdTodo = todoService.createTodo(todo);
        return ResponseEntity.ok(createdTodo);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> listTodos() {
        List<Todo> todos = todoService.listTodos();
        return ResponseEntity.ok(todos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodoStatus(@PathVariable Long id, @RequestBody Todo updatedTodo) {
        Todo todo = todoService.updateTodoStatus(id, updatedTodo.isCompleted());
        return ResponseEntity.ok(todo);
    }
}