package com.esis_to_do_list.mappers;

import com.esis_to_do_list.entities.ToDoList;
import com.esis_to_do_list.models.ToDoListDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ToDoListMapper {
    ToDoListDTO mapEntityToDto(ToDoList toDoList);
    ToDoList mapDtoToEntity(ToDoListDTO toDoListDto);
    List<ToDoList> mapDTOsToEntities(List<ToDoListDTO> toDoListDTOs);
    List<ToDoListDTO> mapEntitiesToDTOs(List<ToDoList> toDoLists);
}

