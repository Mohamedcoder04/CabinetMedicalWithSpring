package com.gestion.cabinetmedical.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestion.cabinetmedical.model.Medicament;
import com.gestion.cabinetmedical.model.Ordonnance;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MedicamentDto {
    private Integer id;
    private String nom;
    private String type;
    private String details;

    @JsonIgnore
    private List<OrdonnanceDto> ordonnances;

    public static MedicamentDto fromEntity(Medicament medicament){
        return MedicamentDto.builder()
                .id(medicament.getId())
                .nom(medicament.getNom())
                .type(medicament.getType())
                .details(medicament.getDetails())
                .build();
    }

    public static Medicament toEntity(MedicamentDto dto){
        Medicament medicament = new Medicament();
        medicament.setId(dto.getId());
        medicament.setNom(dto.getNom());
        medicament.setType(dto.getType());
        medicament.setDetails(dto.getDetails());

        return medicament;
    }
}
