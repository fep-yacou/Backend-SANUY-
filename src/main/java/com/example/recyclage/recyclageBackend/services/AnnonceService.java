package com.example.recyclage.recyclageBackend.services;

import com.example.recyclage.recyclageBackend.models.Annonce;
import com.example.recyclage.recyclageBackend.models.Categorie;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface AnnonceService {
    byte[] getPhoto (Long id) throws IOException;
    List<Annonce> list();
    Annonce ajouterAnnonce (Annonce annonce);
    void miseAjourAnnonce (Annonce annonce, Long id_annonce);
    Annonce annonceParId (Long id_annonce);
    String suppAnnonceById (Long id_annonce);
    List<Annonce> annonceByCategorie(Long categorie);
    int nmbreTotalAnnonce();

}
