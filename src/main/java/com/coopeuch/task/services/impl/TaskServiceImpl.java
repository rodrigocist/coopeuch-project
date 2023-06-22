package com.coopeuch.task.services.impl;

import com.coopeuch.task.dto.TaskDto;
import com.coopeuch.task.exception.TaskException;
import com.coopeuch.task.models.Task;
import com.coopeuch.task.repositories.TaskRepository;
import com.coopeuch.task.services.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ResponseEntity<String> save(TaskDto taskDto) {
        try{
            Task task = modelMapper.map(taskDto, Task.class);
            taskRepository.save(task);
            return new ResponseEntity("save successful", HttpStatus.OK);
        }catch (TaskException e){
            log.error("Error saving = ", e);
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Optional<TaskDto> getById(Long id) throws TaskException {
        Optional<Task> task = taskRepository.findById(id);

        return Optional.ofNullable(
                task
                .map(t -> modelMapper.map(t, TaskDto.class))
                .orElseThrow(() -> new TaskException("Task not found")));
    }



    @Override
    public List<TaskDto> getAll() {
        List<TaskDto> taskDto = new ArrayList<>();
        try{
            List<Task> tasks = taskRepository.findAll();
            taskDto = tasks
                    .stream()
                    .map(task -> modelMapper.map(task, TaskDto.class))
                    .collect(Collectors.toList());
        }catch (TaskException e){
            log.error("Error to get task = ", e);
        }
        return taskDto;
    }

    @Override
    public boolean delete(Long id) {
        try {
            taskRepository.deleteById(id);
            return true;
        }catch (TaskException e){
            log.error("Error to delete", e);
            return false;
        }
    }

}
