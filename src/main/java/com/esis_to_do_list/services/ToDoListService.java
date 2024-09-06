package com.esis_to_do_list.services;


import com.esis_to_do_list.entities.ToDoList;
import com.esis_to_do_list.models.ToDoListDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToDoListService {
    List<ToDoListDTO> findAll(Integer pageSize, Integer pageNum);
    ToDoListDTO findById(Long id);
    void createToDoList(ToDoListDTO toDoList);
    void updateToDoList(Long id, ToDoListDTO toDoList);
    void deleteToDoList(Long id);
    @Query("SELECT t FROM ToDoList t WHERE LOWER(t.code) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<ToDoListDTO> searchByCode(@Param("search") String search);
}
