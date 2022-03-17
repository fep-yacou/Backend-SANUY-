package com.example.recyclage.recyclageBackend.services;

import com.example.recyclage.recyclageBackend.models.Utilisateur;
import com.example.recyclage.recyclageBackend.repositories.UtilisateurRepository;
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
public class UtilisateurServiceImp implements UtilisateurService{
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Override
    public int nombreTotalUtilisateur() {
        List<Utilisateur> listU = utilisateurRepository.findAll();
        int a = listU.size();
        return a;
    }

    @Override
    public byte[] getPhoto(Long id) throws IOException {
        Utilisateur aut = utilisateurRepository.getById(id);
        String iconPhoto = aut.getPhoto_utilisateur();
        File file = new File("src/main/resources/images/profils/"+iconPhoto);
        Path path = Paths.get(file.toURI());

        return Files.readAllBytes(path);
    }

    @Override
    public List<Utilisateur> list() {
        return this.utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        return this.utilisateurRepository.save(utilisateur);
    }

    @Override
    @Transactional
    public void miseAjourUtilisateur(Utilisateur utilisateur, Long id_utilisateur) {
        Utilisateur utilisateurExistant = this.utilisateurRepository.findById(id_utilisateur).get();
        utilisateurExistant.setNom(utilisateur.getNom());
        utilisateurExistant.setPrenom(utilisateur.getPrenom());
        utilisateurExistant.setEmail(utilisateur.getEmail());
        utilisateurExistant.setAdress_utiilisateur(utilisateur.getAdress_utiilisateur());
        utilisateurExistant.setTel(utilisateur.getTel());
        utilisateurExistant.setEtat(utilisateur.getEtat());
        utilisateurExistant.setPassword(utilisateur.getPassword());
        utilisateurExistant.setPhoto_utilisateur(utilisateur.getPhoto_utilisateur());
        utilisateurExistant.setLogin(utilisateur.getLogin());
        utilisateurExistant.setType(utilisateur.getType());
        utilisateurExistant.setAdmin(utilisateur.getAdmin());
    }

    @Override
    public Utilisateur utilisateurParId(Long id_utilisateur) {
        return this.utilisateurRepository.findById(id_utilisateur).get();
    }

    @Override
    public String suppUtilisateurById(Long id_utilisateur) {
        this.utilisateurRepository.deleteById(id_utilisateur);
        return "admin supprimer avec succès";
    }

    @Override
    public Optional<Utilisateur> LoginUtilisateur(String login, String password) {
        return utilisateurRepository.getUtilisateurByLoginAndPassword(login, password);
    }
}
