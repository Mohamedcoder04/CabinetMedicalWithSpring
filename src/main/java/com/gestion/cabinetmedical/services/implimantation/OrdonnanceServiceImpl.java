package com.gestion.cabinetmedical.services.implimantation;

import com.gestion.cabinetmedical.dto.ConsultationDto;
import com.gestion.cabinetmedical.dto.OrdonnanceDto;
import com.gestion.cabinetmedical.exceptions.EntityNotFoundException;
import com.gestion.cabinetmedical.exceptions.ErrorCodes;
import com.gestion.cabinetmedical.exceptions.InvalidEntityException;
import com.gestion.cabinetmedical.model.Medicament;
import com.gestion.cabinetmedical.repositories.ConsultationRepository;
import com.gestion.cabinetmedical.repositories.MedicamentRepository;
import com.gestion.cabinetmedical.repositories.OrdonnanceRepository;
import com.gestion.cabinetmedical.services.OrdonnanceService;
import com.gestion.cabinetmedical.validator.OrdonnanceValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service @Slf4j
public class OrdonnanceServiceImpl implements OrdonnanceService {

    private OrdonnanceRepository ordonnanceRepository;
    private ConsultationRepository consultationRepository;
    private MedicamentRepository medicamentRepository;

    @Autowired
    public OrdonnanceServiceImpl(OrdonnanceRepository ordonnanceRepository, ConsultationRepository consultationRepository, MedicamentRepository medicamentRepository) {
        this.ordonnanceRepository = ordonnanceRepository;
        this.consultationRepository = consultationRepository;
        this.medicamentRepository = medicamentRepository;
    }

    @Override
    public OrdonnanceDto save(OrdonnanceDto dto) {
        List<String> errors = OrdonnanceValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("l'ordonnance n'est pas valide");
            throw new InvalidEntityException("l'ordonnance que vous avez saisi n'est pas valide",
                    errors , ErrorCodes.ORDONNANCE_NOT_VALID);
        }
        ConsultationDto consultationDto = ConsultationDto.fromEntity(
                consultationRepository.findById(dto.getConsultation().getId()).orElseThrow(
                        ()-> new EntityNotFoundException("aucune consultation n'a été trouvé avec l'ID "+ dto.getConsultation().getId()
                                , ErrorCodes.CONSULTATION_NOT_FOUND)
                )
        );
        List<String> medicamentErrors = new ArrayList<>();
        if(dto.getMedicaments() != null){
            dto.getMedicaments().forEach(m->{
                Optional<Medicament> medicament = medicamentRepository.findById(m.getId());
                if(medicament.isEmpty()){
                    medicamentErrors.add("aucun medicament n'a été trouvé avec l'id " + m.getId());
                }
            });
        }

        if(!medicamentErrors.isEmpty()){
            log.warn("");
            throw new EntityNotFoundException("medicaments n'existent pas dans la BBD", ErrorCodes.MEDICAMENT_NOT_FOUND);
        }

        return OrdonnanceDto.fromEntity(
                ordonnanceRepository.save(OrdonnanceDto.toEntity(dto))
        );
    }

    @Override
    public OrdonnanceDto findById(Integer id) {
        if(id == null){
            log.warn("");
            throw new EntityNotFoundException("", ErrorCodes.ORDONNANCE_NOT_FOUND);
        }
        return OrdonnanceDto.fromEntity(
                ordonnanceRepository.findById(id).orElseThrow(
                        ()-> new EntityNotFoundException("aucune ordonnance n'a été trouvé avec l'ID "+id, ErrorCodes.ORDONNANCE_NOT_FOUND)
                )
        );
    }

    @Override
    public List<OrdonnanceDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
