package com.example.recyclage.recyclageBackend.controllers;


import com.example.recyclage.recyclageBackend.models.Categorie;
import com.example.recyclage.recyclageBackend.models.Image;
import com.example.recyclage.recyclageBackend.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/recyclage")
@CrossOrigin("*")
public class CategorieController {
    @Autowired
    CategorieService categorieService;

    @PostMapping("/ajoutCategorie")
    public Categorie ajouterCategorie(@RequestParam("dataC") String categorie,
                                      @RequestParam("file") MultipartFile img)
            throws IOException {
        // Methode pour aploader la photo
        String fileNamePhoto = StringUtils.cleanPath(img.getOriginalFilename());
        Categorie cat = new Categorie();
        cat.setPhoto(fileNamePhoto);
        String uploadDirPhoto = "src/main/resources/images/Categorie" ;

        Image.saveFile(uploadDirPhoto, fileNamePhoto, img);

        //Methode pour enregistrer les donnee
        System.out.println(categorie);

        return this.categorieService.ajoutCategorie(cat);
    }

    @GetMapping(value = "/photoCategorie/{photo}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})

    byte[] getPhoto(@PathVariable("photo") Long id) throws IOException{
        return categorieService.getPhoto(id);
    };

    @GetMapping("/listCategorie")
    public List<Categorie> listerCategorie(){
        return this.categorieService.list();
    }

    @PutMapping("/modifiercategorie/{idcat}")
    public String modifiercategorie(@RequestBody Categorie categorie,@PathVariable("idcat") Long idcat){
        this.categorieService.modifierCategorie(categorie, idcat);
        return "Mis a jour avec success";
    }

    @GetMapping("/infoannonce/{idcat}")
    public Categorie getCategorieById(@PathVariable("idcat") Long idcat){
        return this.categorieService.getCategorieById(idcat);
    }

    @DeleteMapping("supprimercategorie/{idcat}")
    public  String supprimerCategorie(@PathVariable("idcat") Long idcat){
        this.categorieService.supprimerCategorie(idcat);
        return "Categorie supprimer avec succes";
    }
}
