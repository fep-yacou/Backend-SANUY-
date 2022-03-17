package com.example.recyclage.recyclageBackend.models;

import com.example.recyclage.recyclageBackend.enumeration.Etat;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Data
@ToString
@RequiredArgsConstructor
@Entity
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_annonce;
    private String description;
    private String ville;
    private LocalDate date_publication = LocalDate.now();
    private String quartier;
    @Enumerated (EnumType.STRING)
    private Etat etat = Etat.disponible;

    private String photo;
    @ManyToOne
    private Admin admin;
    @ManyToOne
    private Utilisateur utilisateur;
    @ManyToOne
    private Categorie categorie;

    /**public annonce() {
    }

    public Long getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(Long id_annonce) {
        this.id_annonce = id_annonce;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public LocalDate getDate_publication() {
        return date_publication;
    }

    public void setDate_publication(LocalDate date_publication) {
        this.date_publication = date_publication;
    }

    public String getGeolocalisation() {
        return geolocalisation;
    }

    public void setGeolocalisation(String geolocalisation) {
        this.geolocalisation = geolocalisation;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "annonce{" +
                "id_annonce=" + id_annonce +
                ", description='" + description + '\'' +
                ", categorie='" + categorie + '\'' +
                ", date_publication=" + date_publication +
                ", geolocalisation='" + geolocalisation + '\'' +
                ", etat=" + etat +
                '}';
    }**/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Annonce annonce = (Annonce) o;
        return id_annonce != null && Objects.equals(id_annonce, annonce.id_annonce);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

