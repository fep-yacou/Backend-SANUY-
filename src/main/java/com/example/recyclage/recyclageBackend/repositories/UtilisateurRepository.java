package com.example.recyclage.recyclageBackend.repositories;

import com.example.recyclage.recyclageBackend.models.Admin;
import com.example.recyclage.recyclageBackend.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository <Utilisateur, Long> {
    Optional<Utilisateur> getUtilisateurByLoginAndPassword(@PathVariable("login") String login, @PathVariable("password") String password);
}
