package com.example.recyclage.recyclageBackend.services;

import com.example.recyclage.recyclageBackend.models.Categorie;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface CategorieService {
     byte[] getPhoto (Long id) throws IOException;
     Categorie ajoutCategorie(Categorie categorie);
     void modifierCategorie(Categorie categorie, Long idcat);
     List<Categorie> list();
     String supprimerCategorie(Long idcat);
     Categorie getCategorieById(Long idcat);
}
