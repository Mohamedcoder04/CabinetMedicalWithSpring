package com.gestion.cabinetmedical.dto;

import com.gestion.cabinetmedical.model.Adresse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdresseDto {
    private String adresse1;
    private String adresse2;
    private String codePostal;
    private String ville;
    private String pays;

    public static AdresseDto fromEntity(Adresse adresse){
        return AdresseDto.builder()
                .adresse1(adresse.getAdresse1())
                .adresse2(adresse.getAdresse2())
                .codePostal(adresse.getCodePostal())
                .ville(adresse.getVille())
                .pays(adresse.getPays())
                .build();
    }

    public static Adresse toEntity(AdresseDto dto){
        Adresse adresse = new Adresse();
        adresse.setAdresse1(dto.getAdresse1());
        adresse.setAdresse2(dto.getAdresse2());
        adresse.setCodePostal(dto.getCodePostal());
        adresse.setVille(dto.getVille());
        adresse.setPays(dto.getPays());
        return adresse;
    }
}
