package com.example.recyclage.recyclageBackend.controllers;

import com.example.recyclage.recyclageBackend.models.Annonce;
import com.example.recyclage.recyclageBackend.models.Categorie;
import com.example.recyclage.recyclageBackend.models.Image;
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
public class AnnonceController {
    @Autowired
    com.example.recyclage.recyclageBackend.services.AnnonceService annonceService;

    @PostMapping("/ajouterAnnonce")
    public Annonce ajouterAnnonce( @RequestParam("dataA")  String annonce,
                                @RequestParam("file") MultipartFile img)

            throws IOException {
        //Methode for upload photo
        String fileNamePhoto = StringUtils.cleanPath(img.getOriginalFilename());
        Annonce a = new Annonce();
        a.setPhoto(fileNamePhoto);
        String uploadDirPhoto = "src/main/resources/images/" ;

        Image.saveFile(uploadDirPhoto, fileNamePhoto, img);

        //Methode for save data
        System.out.println(annonce);

        return  this.annonceService.ajouterAnnonce(a);

    }

    @GetMapping(value = "/photo/{photo}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})

    byte[] getPhoto(@PathVariable("photo") Long id) throws IOException{
        return annonceService.getPhoto(id);
    };


    @GetMapping ("/listAnnonce")
    public List<Annonce> recupAnnonce () {
        return this.annonceService.list();
    }

    @GetMapping ("/find/{id}")
    public Annonce findParId(@PathVariable("id") Long id) {
        return this.annonceService.annonceParId(id);
    }

    @DeleteMapping("/delete/{id}")
    public String effacerAnnonce(@PathVariable("id") Long id) {
        this.annonceService.suppAnnonceById(id);
        return "Effacer avec success";
    }

    @PutMapping("/modifierAnnonce/{id}")
    public String updateAnnonce (@RequestBody Annonce Annonce, @PathVariable("id") Long id) {
        this.annonceService.miseAjourAnnonce(Annonce, id);
        return "Mis a jour avec success";
    }

    @GetMapping("/annonceByCategorie/{categorie}")
    public List<Annonce> annonceByCategorie(@PathVariable("categorie") Long categorie) {
        return annonceService.annonceByCategorie(categorie);
    }

    @GetMapping("/nmbreAnnonce")
    public int listAnnonce(){
        return annonceService.nmbreTotalAnnonce();
    }



}
