package com.esis_to_do_list.services;


import com.esis_to_do_list.configs.ToDoListConfigsProps;
import com.esis_to_do_list.entities.ToDoList;
import com.esis_to_do_list.exceptions.ToDoListotFoundException;
import com.esis_to_do_list.models.ToDoListDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.esis_to_do_list.repositories.ToDoListRepository;
import com.esis_to_do_list.mappers.ToDoListMapper;

import java.time.LocalDateTime;
import java.util.List;


@Service // Crea Bean servizio
@Transactional
@RequiredArgsConstructor
public class ToDoListServiceImpl implements ToDoListService{

     private final ToDoListRepository toDoListRepository;
     private final ToDoListMapper toDoListMapper;
     private final ToDoListConfigsProps toDoListConfigsProps;

    @Override
    public List<ToDoListDTO> findAll(final Integer pageSize, final Integer pageNum) {
        final Integer pageNumToRequest = pageNum != null ? pageNum : 0;
        final Integer pageSizeToRequest = pageSize != null ? pageSize : 20;

        final Pageable pageable = PageRequest.of(pageNumToRequest, pageSizeToRequest);
        final List<ToDoList> crmList = this.toDoListRepository.findAll(pageable).getContent();
        return this.toDoListMapper.mapEntitiesToDTOs(crmList);
    }

    @Override
    public ToDoListDTO findById(final Long id) {
        final ToDoList crm = this.toDoListRepository
                .findById(id)
                .orElseThrow(() -> new ToDoListotFoundException("not found" + id));
        return this.toDoListMapper.mapEntityToDto(crm);
    }

    @Override
    public void createToDoList(final ToDoListDTO crmDTO) {
        final ToDoList crm = this.toDoListMapper.mapDtoToEntity(crmDTO);
        this.toDoListRepository.save(crm);
    }

    @Override
    public void updateToDoList(final Long id, final ToDoListDTO crmDTO) {
        final ToDoList crm = this.toDoListMapper.mapDtoToEntity(crmDTO);
        final ToDoList currCrm = this.toDoListRepository
                .findById(id)
                .orElseThrow(() -> new ToDoListotFoundException("not found"));

        currCrm.setCode(crm.getCode());
        currCrm.setDescription(crm.getDescription());
        currCrm.setUpdateDate(LocalDateTime.now());

        this.toDoListRepository.save(currCrm);
    }

    @Override
    public void deleteToDoList(final Long id) {
        if (this.toDoListRepository.existsById(id)) {
            this.toDoListRepository.deleteById(id);
        } else {
            throw new ToDoListotFoundException("not found " + id);
        }
    }
}
