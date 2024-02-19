package com.ainotes.backendainotes.model;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String login;
    private String password;
    @Nullable
    private String mail;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Catalog> userNotesCatalogs = new ArrayList<>();


}
