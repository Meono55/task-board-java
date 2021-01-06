package com.benchprojecttaskboard.benchprojecttaskboard.repositories;

import com.benchprojecttaskboard.benchprojecttaskboard.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
