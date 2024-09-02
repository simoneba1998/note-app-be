package com.esis_to_do_list.controllers;


import com.esis_to_do_list.apis.ToDoListAPI;
import com.esis_to_do_list.models.ToDoListDTO;
import com.esis_to_do_list.services.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/esis")
@RequiredArgsConstructor
public class ToDoListController implements ToDoListAPI {
    private final ToDoListService toDoListService;

    @Override
    public ResponseEntity<Void> createToDoList(final ToDoListDTO  toDoListDTO) {
        this.toDoListService.createToDoList(toDoListDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteToDoList(final Long id) {
        this.toDoListService.deleteToDoList(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<ToDoListDTO>> findToDoList(final Integer pageNum, final Integer pageSize) {
        final List<ToDoListDTO> toDoListDTOS = this.toDoListService.findAll(pageSize, pageNum);
        return ResponseEntity.ok(toDoListDTOS);
    }

    @Override
    public ResponseEntity<ToDoListDTO> findToDoListById(final Long id) {
        final ToDoListDTO toDoListDTO = this.toDoListService.findById(id);
        return ResponseEntity.ok(toDoListDTO);
    }

    @Override
    public ResponseEntity<Void> updateToDoList(final Long id, final ToDoListDTO toDoListDTO) {
        this.toDoListService.updateToDoList(id, toDoListDTO);
        return ResponseEntity.noContent().build();
    }
}
