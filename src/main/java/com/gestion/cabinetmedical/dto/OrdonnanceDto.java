package com.gestion.cabinetmedical.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestion.cabinetmedical.model.Consultation;
import com.gestion.cabinetmedical.model.Medicament;
import com.gestion.cabinetmedical.model.Ordonnance;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class OrdonnanceDto {
    private Integer id;
    private Instant date;
    private ConsultationDto consultation;
    @JsonIgnore
    private List<MedicamentDto> medicaments;

    public static OrdonnanceDto fromEntity(Ordonnance ordonnance){
        return OrdonnanceDto.builder()
                .id(ordonnance.getId())
                .date(ordonnance.getDate())
                .consultation(ConsultationDto.fromEntity(ordonnance.getConsultation()))
                .build();
    }

    public static Ordonnance toEntity(OrdonnanceDto dto){
        Ordonnance ordonnance = new Ordonnance();
        ordonnance.setId(dto.getId());
        ordonnance.setDate(dto.getDate());
        ordonnance.setConsultation(ConsultationDto.toEntity(dto.getConsultation()));

        return ordonnance;
    }
}
