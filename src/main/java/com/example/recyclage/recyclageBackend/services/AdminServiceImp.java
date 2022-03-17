package com.example.recyclage.recyclageBackend.services;

import com.example.recyclage.recyclageBackend.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImp implements AdminService {
    @Autowired
    com.example.recyclage.recyclageBackend.repositories.AdminRepository adminRepository;

    @Override
    public byte[] getPhoto(Long id) throws IOException {
        Admin aut = adminRepository.getById(id);
        String iconPhoto = aut.getPhoto_admin();
        File file = new File("src/main/resources/profils/"+iconPhoto);
        Path path = Paths.get(file.toURI());

        return Files.readAllBytes(path);
    }

    @Override
    public List<Admin> list() {
        return this.adminRepository.findAll();
    }


    @Override
    public Admin ajouterAdmin(Admin admin) {
       return this.adminRepository.save(admin);
    }

    @Override
    @Transactional
    public void miseAjourAdmin(Admin Admin, Long id_admin) {
        com.example.recyclage.recyclageBackend.models.Admin adminExistant = this.adminRepository.findById(id_admin).orElseThrow();
        adminExistant.setNom(Admin.getNom());
        adminExistant.setPrenom(Admin.getPrenom());
        adminExistant.setEmail(Admin.getEmail());
        adminExistant.setAdress_admin(Admin.getAdress_admin());
        adminExistant.setTel(Admin.getTel());
        adminExistant.setEtat(Admin.getEtat());
        adminExistant.setPassword(Admin.getPassword());

    }

    @Override
    public Admin adminParId(Long id_admin) {
        return this.adminRepository.findById(id_admin).get();
    }

    @Override
    public String suppAdminById(Long id_admin) {
        this.adminRepository.deleteById(id_admin);
        return "admin supprimer avec succès";
    }

    @Override
    public Optional<Admin> LonginUser(String login, String password) {
        return adminRepository.getUserByLoginAndPassword(login, password);
    }

}
