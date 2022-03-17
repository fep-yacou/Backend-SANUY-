package com.example.recyclage.recyclageBackend.services;

import com.example.recyclage.recyclageBackend.models.Admin;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public interface AdminService {
    byte[] getPhoto (Long id) throws IOException;
    List<Admin> list();
    Admin ajouterAdmin (Admin admin);
    void miseAjourAdmin (Admin admin, Long id_admin);
    Admin adminParId (Long id_admin);
    String suppAdminById (Long id_admin);
    Optional<Admin> LonginUser (String login, String password);
}
