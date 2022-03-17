package com.example.recyclage.recyclageBackend.controllers;


import com.example.recyclage.recyclageBackend.models.Image;
import com.example.recyclage.recyclageBackend.models.Utilisateur;
import com.example.recyclage.recyclageBackend.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recyclage")
@CrossOrigin("*")
public class UtilisateurController {
    @Autowired
    UtilisateurService utilisateurService;

    @PostMapping("/ajoutUtilisateur")
    public Utilisateur ajoutUtilisateur (@RequestParam("dataU") String utilisateur,
                                @RequestParam("file") MultipartFile img)
            throws Exception {
        // Methode pour charger la photo
        String fileNamePhoto = StringUtils.cleanPath(img.getOriginalFilename());
        Utilisateur u = new Utilisateur();
        u.setPhoto_utilisateur(fileNamePhoto);
        String uploadDirPhoto = "src/main/resources/images/profils/";

        Image.saveFile(uploadDirPhoto, fileNamePhoto, img);

        // Methode pour enregistrer les donnees
        System.out.println(utilisateur);

        return  this.utilisateurService.ajouterUtilisateur(u);
    }

    @GetMapping(value = "/photo_utilisateur/{photo_utilisateur}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})

    byte[] getPhoto(@PathVariable("photo_utilisateur") Long id) throws Exception{
        return utilisateurService.getPhoto(id);
    }

    @GetMapping ("/listUtilisateur")
    public List<Utilisateur> recupUtilisateur () {
        return this.utilisateurService.list();
    }

    @GetMapping ("/findUtilisateur/{id}")
    public Utilisateur findUtilisateurParId(@PathVariable("id") Long id) {
        return this.utilisateurService.utilisateurParId(id);
    }

    @DeleteMapping("/deleteUtilisateur/{id}")
    public String effacerUtilisateur(@PathVariable("id") Long id) {
        this.utilisateurService.suppUtilisateurById(id);
        return "Utilisateur Effacer avec success";
    }

    @GetMapping("/loginUtilisateur/{login}&{password}")
    public Optional<Utilisateur> loginUtilisateur(@PathVariable("login") String login, @PathVariable("password") String password) {
        return utilisateurService.LoginUtilisateur(login, password);
    }

    @PutMapping("/modifierUtilisateur/{id}")
    public String updateUtilisateur (@RequestBody Utilisateur utilisateur, @PathVariable("id") Long id) {
        this.utilisateurService.miseAjourUtilisateur(utilisateur, id);
        return "Utilisateur mis a jour avec success";
    }

    @GetMapping("/nmbreUser")
    public int listUser(){
        return utilisateurService.nombreTotalUtilisateur();
    }
}
