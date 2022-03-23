package com.example.recyclage.recyclageBackend.controllers;


import com.example.recyclage.recyclageBackend.EmailSenderService;
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

    @Autowired
    EmailSenderService emailSenderService;

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

    @GetMapping("/sendEmail/{email}/{body}/{subject}")
    public String SendEmail(@PathVariable("email") String email, @PathVariable("body") String body, @PathVariable("subject") String subject){
        emailSenderService.sendSimpleEmail(email, body, subject);
        return "message.............";
    }
}
