package com.esis_to_do_list.repositories;
import com.esis_to_do_list.entities.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
}
