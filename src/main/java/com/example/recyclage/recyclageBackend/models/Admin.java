package com.example.recyclage.recyclageBackend.models;

import com.example.recyclage.recyclageBackend.enumeration.Etat;
import com.example.recyclage.recyclageBackend.enumeration.Type;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private Integer tel;
    private String login;
    private String password;
    private String adress_admin;
    @Enumerated(EnumType.STRING)
    private Etat etat;
    private String photo_admin;
    @Enumerated(EnumType.STRING)
    private Type type;
}

