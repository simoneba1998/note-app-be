package com.esis_to_do_list.repositories;

import com.esis_to_do_list.entities.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
    // Puoi aggiungere metodi di query personalizzati qui, se necessario


    // Metodo personalizzato per cercare per "code" ignorando maiuscole/minuscole
    List<ToDoList> findByCodeContainingIgnoreCase(String code);
}
