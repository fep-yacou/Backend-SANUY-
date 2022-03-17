package com.example.recyclage.recyclageBackend.services;

import com.example.recyclage.recyclageBackend.models.Categorie;
import com.example.recyclage.recyclageBackend.models.DemandeAnnonce;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DemandeAnnonceService {
    DemandeAnnonce ajoutDemandeAnoonce(DemandeAnnonce demandeAnnonce);
    DemandeAnnonce modifierDemandeAnnonce(DemandeAnnonce demandeAnnonce, Long id);
    List<DemandeAnnonce> list();
    String supprimerDemandeAnnonce(Long id);
    DemandeAnnonce getDemandeAnnonceById(Long id);
}
