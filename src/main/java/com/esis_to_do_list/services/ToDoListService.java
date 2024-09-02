package com.esis_to_do_list.services;

import com.esis_to_do_list.models.ToDoListDTO;

import java.util.List;

public interface ToDoListService {
    List<ToDoListDTO> findAll(Integer pageSize, Integer pageNum);
    ToDoListDTO findById(Long id);
    void createToDoList(ToDoListDTO toDoList);
    void updateToDoList(Long id, ToDoListDTO toDoList);
    void deleteToDoList(Long id);
}
