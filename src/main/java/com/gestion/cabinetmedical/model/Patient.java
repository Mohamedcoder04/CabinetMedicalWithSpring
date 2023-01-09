package com.gestion.cabinetmedical.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @EqualsAndHashCode(callSuper = true)
public class Patient extends AbstractEntity {

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "datenaissance")
    private Instant dateNaissance;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sexe")
    private String sexe;

    @Embedded
    @Column(name = "adresse")
    private Adresse adresse;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "photo")
    private String photo;

    @OneToMany(mappedBy = "patient")
    private List<Consultation> consultations;

    @ManyToOne
    @JoinColumn(name = "secretaire_id")
    private Secretaire secretaire;

    @ManyToOne
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;

    @OneToMany(mappedBy = "patient")
    private List<RendezVous> rendezVousList;
}
