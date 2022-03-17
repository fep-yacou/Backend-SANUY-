package com.example.recyclage.recyclageBackend.services;

import com.example.recyclage.recyclageBackend.models.DemandeAnnonce;
import com.example.recyclage.recyclageBackend.repositories.DemandeAnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DemandeAnnonceServiceImp implements DemandeAnnonceService{
    @Autowired
    DemandeAnnonceRepository demandeAnnonceRepository;

    @Override
    public DemandeAnnonce ajoutDemandeAnoonce(DemandeAnnonce demandeAnnonce) {
        return this.demandeAnnonceRepository.save(demandeAnnonce);
    }

    @Override
    @Transactional
    public DemandeAnnonce modifierDemandeAnnonce(DemandeAnnonce demandeAnnonce, Long id) {
        DemandeAnnonce demandeAnnonceExistant = this.demandeAnnonceRepository.findById(id).get();
        demandeAnnonceExistant.setAnnonce(demandeAnnonce.getAnnonce());
        demandeAnnonceExistant.setEtatAnnonce(demandeAnnonce.getEtatAnnonce());
        demandeAnnonceExistant.setAdmin(demandeAnnonce.getAdmin());
        demandeAnnonceExistant.setUtilisateur(demandeAnnonce.getUtilisateur());
        demandeAnnonceExistant.setDateDemande(demandeAnnonce.getDateDemande());
        demandeAnnonceExistant.setDateDemandeAccept(demandeAnnonce.getDateDemandeAccept());
        demandeAnnonceExistant.setUserView(demandeAnnonce.getUserView());
        return this.demandeAnnonceRepository.save(demandeAnnonceExistant);
    }

    @Override
    public List<DemandeAnnonce> list() {
        return this.demandeAnnonceRepository.findAll();
    }

    @Override
    public String supprimerDemandeAnnonce(Long id) {
        this.demandeAnnonceRepository.deleteById(id);
        return "DemandeAnnonce supprimer avec succes";
    }

    @Override
    public DemandeAnnonce getDemandeAnnonceById(Long id) {
        return this.demandeAnnonceRepository.findById(id).get();
    }
}
