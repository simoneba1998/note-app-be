package com.esis_to_do_list.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name= "to_do_list")
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "code")
    private String code;

    @Column(name= "description")
    private String description;
}
