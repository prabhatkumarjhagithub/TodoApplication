package com.example.TodoApplication.Service;


//import com.example.todoapp.model.Todo;
//import com.example.todoapp.repository.TodoRepository;
import com.example.TodoApplication.Model.Todo;
import com.example.TodoApplication.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {


    @Autowired
    TodoRepository todoRepository;

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> listTodos() {
        return todoRepository.findAllByOrderByCreatedAtDesc();
    }

    public Todo updateTodoStatus(Long id, boolean completed) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid todo ID"));
        todo.setCompleted(completed);
        return todoRepository.save(todo);
    }
}