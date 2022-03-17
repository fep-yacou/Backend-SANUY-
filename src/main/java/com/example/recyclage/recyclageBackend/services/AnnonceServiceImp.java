package com.example.recyclage.recyclageBackend.services;

import com.example.recyclage.recyclageBackend.models.Admin;
import com.example.recyclage.recyclageBackend.models.Annonce;
import com.example.recyclage.recyclageBackend.models.Categorie;
import com.example.recyclage.recyclageBackend.models.Utilisateur;
import com.example.recyclage.recyclageBackend.repositories.CategorieRepository;
import com.example.recyclage.recyclageBackend.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class AnnonceServiceImp implements AnnonceService {
    @Autowired
    com.example.recyclage.recyclageBackend.repositories.AnnonceRepository annonceRepository;
    @Autowired
    com.example.recyclage.recyclageBackend.repositories.AdminRepository adminRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    CategorieRepository categorieRepository;



    @Override
    public List<Annonce> list() {
        return this.annonceRepository.findAll();
    }

    @Override
    public Annonce ajouterAnnonce(Annonce annonce) {
        return this.annonceRepository.save(annonce);
    }

    @Override
    @Transactional
    public void miseAjourAnnonce(Annonce Annonce, Long id_annonce) {
        com.example.recyclage.recyclageBackend.models.Annonce annonceExistant = this.annonceRepository.findById(id_annonce).orElseThrow();
        annonceExistant.setDescription(Annonce.getDescription());
        annonceExistant.setCategorie(Annonce.getCategorie());
        annonceExistant.setEtat(Annonce.getEtat());
        annonceExistant.setUtilisateur(Annonce.getUtilisateur());
        annonceExistant.setAdmin(Annonce.getAdmin());
        annonceExistant.setVille(Annonce.getVille());
        annonceExistant.setDate_publication(Annonce.getDate_publication());
        annonceExistant.setPhoto(Annonce.getPhoto());
        annonceExistant.setCategorie(Annonce.getCategorie());
        annonceExistant.setQuartier(Annonce.getQuartier());

    }


    @Override
    public Annonce annonceParId(Long id_annonce) {
        return this.annonceRepository.findById(id_annonce).get();
    }

    @Override
    public String suppAnnonceById(Long id_annonce) {
        this.annonceRepository.deleteById(id_annonce);
        return "Annonce Supprimer avec sucess";
    }

    @Override
    public List<Annonce> annonceByCategorie(Long categorie) {
        Categorie categ = categorieRepository.findById(categorie).get();
        return annonceRepository.findByCategorie(categ);
    }

    @Override
    public int nmbreTotalAnnonce() {
        List<Annonce> listA = annonceRepository.findAll();
        int an = listA.size();
        return an;
    }

    @Override
    public byte[] getPhoto(Long id) throws IOException {
        Annonce aut = annonceRepository.getById(id);
        String iconPhoto = aut.getPhoto();
        File file = new File("src/main/resources/images/"+iconPhoto);
        Path path = Paths.get(file.toURI());

        return Files.readAllBytes(path);
    }
}
