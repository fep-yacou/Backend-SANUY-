package com.example.recyclage.recyclageBackend.repositories;

import com.example.recyclage.recyclageBackend.models.Annonce;
import com.example.recyclage.recyclageBackend.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
    List<Annonce> findByCategorie(Categorie categorie);
}
