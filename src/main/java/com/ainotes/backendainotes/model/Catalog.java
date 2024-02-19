package com.ainotes.backendainotes.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Catalog")
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
