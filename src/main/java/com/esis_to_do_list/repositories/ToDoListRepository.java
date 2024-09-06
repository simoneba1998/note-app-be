package com.esis_to_do_list.repositories;
import com.esis_to_do_list.entities.ToDoList;
import com.esis_to_do_list.models.ToDoListDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
    List<ToDoList> findByCodeContainingIgnoreCase(String search);
}
