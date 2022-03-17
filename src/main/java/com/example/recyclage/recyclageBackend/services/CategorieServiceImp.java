package com.example.recyclage.recyclageBackend.services;

import com.example.recyclage.recyclageBackend.models.Categorie;
import com.example.recyclage.recyclageBackend.repositories.CategorieRepository;
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
public class CategorieServiceImp implements CategorieService{
    @Autowired
    CategorieRepository categorieRepository;

    @Override
    public byte[] getPhoto(Long id) throws IOException {
        Categorie aut = categorieRepository.getById(id);
        String iconPhoto = aut.getPhoto();
        File file = new File("src/main/resources/images/Categorie"+iconPhoto);
        Path path = Paths.get(file.toURI());

        return Files.readAllBytes(path);
    }

    @Override
    public Categorie ajoutCategorie(Categorie categorie) {
        return this.categorieRepository.save(categorie);
    }

    @Override
    @Transactional
    public void modifierCategorie(Categorie categorie, Long idcat) {
        Categorie categorieExistant = this.categorieRepository.findById(idcat).get();
        categorieExistant.setType(categorie.getType());
        categorieExistant.setAdmin(categorie.getAdmin());
        categorieExistant.setPhoto(categorie.getPhoto());
    }

    @Override
    public List<Categorie> list() {
        return this.categorieRepository.findAll();
    }

    @Override
    public String supprimerCategorie(Long idcat) {
        this.categorieRepository.deleteById(idcat);
        return "Categorie supprimer avec succes";
    }

    @Override
    public Categorie getCategorieById(Long idcat) {
        return this.categorieRepository.findById(idcat).get();
    }
}
