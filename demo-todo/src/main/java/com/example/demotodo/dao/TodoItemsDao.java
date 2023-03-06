package com.example.demotodo.dao;

import com.example.demotodo.ds.TodoItems;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemsDao extends CrudRepository<TodoItems, Integer> {
}
