package com.coopeuch.task.controllers;

import com.coopeuch.task.dto.TaskDto;
import com.coopeuch.task.models.Task;
import com.coopeuch.task.services.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/v_1/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<TaskDto> getAll(){
        return taskService.getAll();
    }

    @GetMapping("{id}")
    public Optional<TaskDto> getById(@PathVariable("id") Long id){
        return taskService.getById(id);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody TaskDto task){
        return new ResponseEntity(taskService.save(task), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody TaskDto task){
        return new ResponseEntity(taskService.save(task), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        return new ResponseEntity(taskService.delete(id), HttpStatus.ACCEPTED);
    }

}
