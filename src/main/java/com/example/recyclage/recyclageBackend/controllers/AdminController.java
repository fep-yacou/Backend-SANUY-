package com.example.recyclage.recyclageBackend.controllers;

import com.example.recyclage.recyclageBackend.models.Admin;
import com.example.recyclage.recyclageBackend.models.Image;
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
public class AdminController {
    @Autowired
    com.example.recyclage.recyclageBackend.services.AdminService adminService;

    @PostMapping("/ajoutAdmin")
    public String ajoutAnnonce (@RequestParam("dataB") String admin,
                                @RequestParam("file")MultipartFile img)
            throws Exception {
        // Methode pour charger la photo
        String fileNamePhoto = StringUtils.cleanPath(img.getOriginalFilename());
        Admin adm = new Admin();
        adm.setPhoto_admin(fileNamePhoto);
        String uploadDirPhoto = "src/main/resources/profils/";

        Image.saveFile(uploadDirPhoto, fileNamePhoto, img);

        // Methode pour enregistrer les donnees
        this.adminService.ajouterAdmin(adm);
        return "Admin ajouter avec success";
    }

    @GetMapping(value = "/photo_admin/{photo_admin}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})

    byte[] getPhoto(@PathVariable("photo_admin") Long id) throws Exception{
        return adminService.getPhoto(id);
    }



    @GetMapping ("/listAdmin")
    public List<Admin> recupAdmin () {
        return this.adminService.list();
    }

    @GetMapping ("/findAdmin/{id}")
    public Admin findParId(@PathVariable("id") Long id) {
        return this.adminService.adminParId(id);
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public String effacerAdmin(@PathVariable("id") Long id) {
        this.adminService.suppAdminById(id);
        return "Admin Effacer avec success";
    }

    @GetMapping("/login/{login}&{password}")
    public Optional<Admin> loginUser(@PathVariable("login") String login, @PathVariable("password") String password) {
        return adminService.LonginUser(login, password);
    }

    @PutMapping("/modifierAdmin/{id}")
    public String updateAdmin (@RequestBody Admin admin, @PathVariable("id") Long id) {
        this.adminService.miseAjourAdmin(admin, id);
        return "Admin mis a jour avec success";
    }
}
