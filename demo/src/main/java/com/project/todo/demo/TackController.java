package com.project.todo.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@CrossOrigin(origins = "http://localhost:64923", methods = {DELETE, GET, POST, PUT, OPTIONS})  //3000
@RequestMapping("/tasks")
public class TackController {
    private final TaskRepository repository;

    public TackController(TaskRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    public List<Task> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return repository.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
