package com.example.recyclage.recyclageBackend.repositories;

import com.example.recyclage.recyclageBackend.models.DemandeAnnonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeAnnonceRepository extends JpaRepository <DemandeAnnonce, Long> {
}
