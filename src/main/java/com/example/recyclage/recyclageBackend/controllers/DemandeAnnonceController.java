package com.example.recyclage.recyclageBackend.controllers;


import com.example.recyclage.recyclageBackend.models.DemandeAnnonce;
import com.example.recyclage.recyclageBackend.services.DemandeAnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recyclage")
@CrossOrigin("*")
public class DemandeAnnonceController {
    @Autowired
    DemandeAnnonceService demandeAnnonceService;

    @PostMapping("/ajoutDemandeAnnonce")
    public DemandeAnnonce demandeAnnonce(@RequestBody DemandeAnnonce demandeAnnonce){
        return this.demandeAnnonceService.ajoutDemandeAnoonce(demandeAnnonce) ;
    }

    @GetMapping("/listDemandeAnnonce")
    public List<DemandeAnnonce> recupDemandeAnnonce () {
        return this.demandeAnnonceService.list();
    }

    @GetMapping ("/getDemandeAnnonce/{id}")
    public DemandeAnnonce findParId(@PathVariable("id") Long id) {
        return this.demandeAnnonceService.getDemandeAnnonceById(id);
    }

    @DeleteMapping("/deleteDemandeAnnonce/{id}")
    public String effacerDemandeAnnonce(@PathVariable("id") Long id) {
        this.demandeAnnonceService.supprimerDemandeAnnonce(id);
        return "Effacer avec success";
    }

    @PutMapping("/modifierDemandeAnnonce/{id}")
    public DemandeAnnonce updateDemandeAnnonce (@RequestBody DemandeAnnonce demandeAnnonce, @PathVariable("id") Long id) {
        return this.demandeAnnonceService.modifierDemandeAnnonce(demandeAnnonce, id);
    }
}
