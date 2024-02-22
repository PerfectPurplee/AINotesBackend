package com.ainotes.backendainotes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data
@Entity
public class Note {

    @Id
    private Long id;
    private String content;
    private String title;

    @ManyToOne
    private Catalog catalog;

}
