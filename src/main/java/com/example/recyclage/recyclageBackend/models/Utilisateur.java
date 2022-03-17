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
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private Integer tel;
    private String login;
    private String password;
    private String adress_utiilisateur;
    @Enumerated(EnumType.STRING)
    private Etat etat = Etat.disponible;
    private String photo_utilisateur;
    @Enumerated(EnumType.STRING)
    private Type type;
    @ManyToOne
    private Admin admin;

}
