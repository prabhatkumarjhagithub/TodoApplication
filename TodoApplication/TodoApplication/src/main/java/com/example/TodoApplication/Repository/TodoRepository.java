package com.example.TodoApplication.Repository;
//import com.example.todoapp.model.Todo;
import com.example.TodoApplication.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    // Custom query method to find all ToDos ordered by creation date in descending order
    List<Todo> findAllByOrderByCreatedAtDesc();
}