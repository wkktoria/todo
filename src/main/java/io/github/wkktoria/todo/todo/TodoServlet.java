package io.github.wkktoria.todo.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
class TodoServlet {
    private final Logger logger = LoggerFactory.getLogger(TodoServlet.class);
    private final TodoRepository repository;

    TodoServlet(TodoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    ResponseEntity<List<Todo>> findAllTodos() {
        logger.info("GOT request");
        return ResponseEntity.ok(repository.findAll());
    }

    @PutMapping("/{id}")
    ResponseEntity<Todo> toggleTodo(@PathVariable("id") Long id) {
        logger.info("PUT request");
        var todo = repository.findById(id);
        todo.ifPresent(t -> {
            t.setDone(!t.getDone());
            repository.save(t);
        });
        return todo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<Todo> saveTodo(@RequestBody Todo todo) {
        logger.info("POST request");
        return ResponseEntity.ok(repository.save(todo));
    }
}