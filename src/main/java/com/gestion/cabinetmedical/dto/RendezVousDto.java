package com.gestion.cabinetmedical.dto;

import com.gestion.cabinetmedical.model.*;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class RendezVousDto {
    private Integer id;
    private Instant date;
    private SecretaireDto secretaire;
    private MedecinDto medecin;
    private PatientDto patient;

    public static RendezVousDto fromEntity(RendezVous rendezVous){
        return RendezVousDto.builder()
                .id(rendezVous.getId())
                .date(rendezVous.getDate())
                .secretaire(SecretaireDto.fromEntity(rendezVous.getSecretaire()))
                .medecin(MedecinDto.fromEntity(rendezVous.getMedecin()))
                .build();
    }

    public static RendezVous toEntity(RendezVousDto dto){
        RendezVous rendezVous = new RendezVous();
        rendezVous.setId(dto.getId());
        rendezVous.setDate(dto.getDate());
        rendezVous.setSecretaire(SecretaireDto.toEntity(dto.getSecretaire()));
        rendezVous.setMedecin(MedecinDto.toEntity(dto.getMedecin()));

        return rendezVous;
    }
}
