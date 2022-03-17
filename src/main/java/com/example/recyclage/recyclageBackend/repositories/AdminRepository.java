package com.example.recyclage.recyclageBackend.repositories;

import com.example.recyclage.recyclageBackend.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface AdminRepository extends JpaRepository <Admin, Long> {
    Optional<Admin> getUserByLoginAndPassword(@PathVariable("login") String login, @PathVariable("password") String password);
}
