package com.example.recyclage.recyclageBackend.services;

import com.example.recyclage.recyclageBackend.models.Utilisateur;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public interface UtilisateurService {
    byte[] getPhoto (Long id) throws IOException;
    List<Utilisateur> list();
    Utilisateur ajouterUtilisateur (Utilisateur utilisateur);
    void miseAjourUtilisateur (Utilisateur utilisateur, Long id_utilisateur);
    Utilisateur utilisateurParId (Long id_utilisateur);
    String suppUtilisateurById (Long id_utilisateur);
    Optional<Utilisateur> LoginUtilisateur (String login, String password);
    int nombreTotalUtilisateur();
}
