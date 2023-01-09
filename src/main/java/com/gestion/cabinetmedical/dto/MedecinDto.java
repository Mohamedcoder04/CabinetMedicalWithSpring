package com.gestion.cabinetmedical.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestion.cabinetmedical.model.Consultation;
import com.gestion.cabinetmedical.model.Medecin;
import com.gestion.cabinetmedical.model.Patient;
import com.gestion.cabinetmedical.model.RendezVous;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MedecinDto {
    private Integer id;
    private String nom;

    private String prenom;

    private String email;

    private String password;

    @JsonIgnore
    private List<ConsultationDto> consultations;

    @JsonIgnore
    private List<PatientDto> patients;

    @JsonIgnore
    private List<RendezVousDto> rendezVousList;

    public static MedecinDto fromEntity(Medecin medecin) {
        return MedecinDto.builder()
                .id(medecin.getId())
                .nom(medecin.getNom())
                .prenom(medecin.getPrenom())
                .email(medecin.getEmail())
                .password(medecin.getPassword())
                .build();
    }

    public static Medecin toEntity(MedecinDto dto){
        Medecin medecin = new Medecin();
        medecin.setId(dto.getId());
        medecin.setNom(dto.getNom());
        medecin.setPrenom(dto.getPrenom());
        medecin.setEmail(dto.getEmail());
        medecin.setPassword(dto.getPassword());

        return medecin;
    }

}
