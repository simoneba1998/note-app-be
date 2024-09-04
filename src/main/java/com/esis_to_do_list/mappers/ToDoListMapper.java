package com.esis_to_do_list.mappers;

import com.esis_to_do_list.entities.ToDoList;
import com.esis_to_do_list.models.ToDoListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Mapper
public interface ToDoListMapper {

    ToDoListMapper INSTANCE = Mappers.getMapper(ToDoListMapper.class);

    @Mappings({
            @Mapping(source = "updateDate", target = "updateDate", qualifiedByName = "localDateTimeToOffsetDateTime")
    })
    ToDoListDTO mapEntityToDto(ToDoList toDoList);

    @Mappings({
            @Mapping(source = "updateDate", target = "updateDate", qualifiedByName = "offsetDateTimeToLocalDateTime")
    })
    ToDoList mapDtoToEntity(ToDoListDTO toDoListDto);


    List<ToDoList> mapDTOsToEntities(List<ToDoListDTO> toDoListDTOs);
    List<ToDoListDTO> mapEntitiesToDTOs(List<ToDoList> toDoLists);





    // Conversion methods
    @org.mapstruct.Named("localDateTimeToOffsetDateTime")
    default OffsetDateTime localDateTimeToOffsetDateTime(LocalDateTime localDateTime) {
        return localDateTime != null ? localDateTime.atOffset(ZoneOffset.UTC) : null;
    }

    @org.mapstruct.Named("offsetDateTimeToLocalDateTime")
    default LocalDateTime offsetDateTimeToLocalDateTime(OffsetDateTime offsetDateTime) {
        return offsetDateTime != null ? offsetDateTime.toLocalDateTime() : null;
    }
}