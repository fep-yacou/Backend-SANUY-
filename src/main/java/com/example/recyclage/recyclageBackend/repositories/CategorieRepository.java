package com.example.recyclage.recyclageBackend.repositories;

import com.example.recyclage.recyclageBackend.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository <Categorie, Long> {
}
