package com.ainotes.backendainotes.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String catalogName;

    @ManyToOne
    private User user;


}
