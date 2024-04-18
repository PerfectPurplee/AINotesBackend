package com.ainotes.backendainotes.dto.usercontent;

import lombok.Data;

import java.util.List;

@Data
public class Catalog {

    private int id;
    private String name;
    private List<Note> userNotes;
}
