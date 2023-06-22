package com.coopeuch.task.repositories;

import com.coopeuch.task.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
