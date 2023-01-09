package com.gestion.cabinetmedical.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data @NoArgsConstructor
@AllArgsConstructor @Entity
@EqualsAndHashCode(callSuper = true)
public class Secretaire extends AbstractEntity {

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @Column(name = "photo")
    private String photo;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "secretaire")
    private List<RendezVous> rendezVousList;

    @OneToMany(mappedBy = "secretaire")
    private List<Patient> patient;
}
