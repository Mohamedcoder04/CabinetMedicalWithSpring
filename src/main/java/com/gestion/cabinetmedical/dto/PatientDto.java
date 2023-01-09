package com.gestion.cabinetmedical.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestion.cabinetmedical.model.*;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data @Builder
public class PatientDto {
    private Integer id;
    private String nom;
    private String prenom;
    private Instant dateNaissance;
    private Integer age;
    private String sexe;
    @Embedded
    private AdresseDto adresse;
    private String telephone;
    private SecretaireDto secretaire;
    private MedecinDto medecin;

    @JsonIgnore
    private List<ConsultationDto> consultations;
    @JsonIgnore
    private List<RendezVousDto> rendezVousList;

    public static PatientDto fromEntity(Patient patient){
        return PatientDto.builder()
                .nom(patient.getNom())
                .prenom(patient.getPrenom())
                .dateNaissance(patient.getDateNaissance())
                .age(patient.getAge())
                .sexe(patient.getSexe())
                .adresse(AdresseDto.fromEntity(patient.getAdresse()))
                .telephone(patient.getTelephone())
                .secretaire(SecretaireDto.fromEntity(patient.getSecretaire()))
                .medecin(MedecinDto.fromEntity(patient.getMedecin()))
                .build();
    }

    public static Patient toEntity(PatientDto dto){
        Patient patient = new Patient();
        patient.setNom(dto.getNom());
        patient.setPrenom(dto.getPrenom());
        patient.setDateNaissance(dto.getDateNaissance());
        patient.setAge(dto.getAge());
        patient.setSexe(dto.getSexe());
        patient.setAdresse(AdresseDto.toEntity(dto.getAdresse()));
        patient.setTelephone(dto.getTelephone());
        patient.setSecretaire(SecretaireDto.toEntity(dto.getSecretaire()));
        patient.setMedecin(MedecinDto.toEntity(dto.getMedecin()));
        return patient;
    }

}
