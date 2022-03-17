package com.example.recyclage.recyclageBackend.models;


import com.example.recyclage.recyclageBackend.enumeration.Etat;
import com.example.recyclage.recyclageBackend.enumeration.EtatAnnonce;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class DemandeAnnonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Annonce annonce;
    @ManyToOne
    private Admin admin;
    @ManyToOne
    private Utilisateur utilisateur;
    @Enumerated(EnumType.STRING)
    private EtatAnnonce etatAnnonce;
    private LocalDate DateDemande = LocalDate.now();
    private LocalDate DateDemandeAccept;
    private String userView;
}
