package com.gestion.cabinetmedical.dto;

import com.gestion.cabinetmedical.model.RendezVous;
import com.gestion.cabinetmedical.model.Secretaire;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SecretaireDto {
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private List<RendezVousDto> rendezVousList;
    private List<PatientDto> patient;

    public static SecretaireDto fromEntity(Secretaire secretaire){
        return SecretaireDto.builder()
                .id(secretaire.getId())
                .nom(secretaire.getNom())
                .prenom(secretaire.getPrenom())
                .email(secretaire.getEmail())
                .password(secretaire.getPassword())
                .build();
    }

    public static Secretaire toEntity(SecretaireDto dto){
        Secretaire secretaire = new Secretaire();
        secretaire.setId(dto.getId());
        secretaire.setNom(dto.getNom());
        secretaire.setPrenom(dto.getPrenom());
        secretaire.setEmail(dto.getEmail());
        secretaire.setPassword(dto.getPassword());

        return secretaire;
    }

}
