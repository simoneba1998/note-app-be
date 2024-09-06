package com.esis_to_do_list.controllers;


import com.esis_to_do_list.apis.SearchToDoListAPI;
import com.esis_to_do_list.apis.ToDoListAPI;
import com.esis_to_do_list.entities.ToDoList;
import com.esis_to_do_list.models.ToDoListDTO;
import com.esis_to_do_list.services.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/esis")
@RequiredArgsConstructor
public class ToDoListController implements ToDoListAPI, SearchToDoListAPI {
    private final ToDoListService toDoListService;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return ToDoListAPI.super.getRequest();
    }

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

    @Override
    public ResponseEntity<List<ToDoListDTO>> findBySearch(final String search) {
       final List<ToDoListDTO> toDoList =this.toDoListService.searchByCode(search);
       return ResponseEntity.ok(toDoList);
    }
}
