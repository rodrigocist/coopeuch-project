package com.coopeuch.task.services;

import com.coopeuch.task.dto.TaskDto;
import com.coopeuch.task.exception.TaskException;
import com.coopeuch.task.models.Task;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    ResponseEntity<String> save(TaskDto task);

    Optional<TaskDto> getById(Long id) throws TaskException;

    List<TaskDto> getAll();

    boolean delete(Long id);
}
