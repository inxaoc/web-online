package com.in28minutes.springboot.repo;

import org.springframework.data.repository.CrudRepository;

import com.in28minutes.springboot.web.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends CrudRepository<Todo, Long> {
    List<Todo> findByUser(String user);
}
