package com.gestion.cabinetmedical.services.implimantation;

import com.gestion.cabinetmedical.dto.MedicamentDto;
import com.gestion.cabinetmedical.exceptions.EntityNotFoundException;
import com.gestion.cabinetmedical.exceptions.ErrorCodes;
import com.gestion.cabinetmedical.exceptions.InvalidEntityException;
import com.gestion.cabinetmedical.repositories.MedicamentRepository;
import com.gestion.cabinetmedical.services.MedicamentService;
import com.gestion.cabinetmedical.validator.MedicamentValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MedicamentServiceImpl implements MedicamentService {

    private MedicamentRepository medicamentRepository;

    @Autowired
    public MedicamentServiceImpl(MedicamentRepository medicamentRepository) {
        this.medicamentRepository = medicamentRepository;
    }

    @Override
    public MedicamentDto save(MedicamentDto dto) {
        List<String> errors = MedicamentValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("medicament n'est pas valid");
            throw new InvalidEntityException("medicament que vous avez saisi n'est pas valide"
                    , ErrorCodes.MEDICAMENT_NOT_VALID);
        }
        return MedicamentDto.fromEntity(
                medicamentRepository.save(MedicamentDto.toEntity(dto))
        );
    }

    @Override
    public MedicamentDto findById(Integer id) {
        if(id == null){
            log.warn("");
            throw new EntityNotFoundException("l'id est NULL", ErrorCodes.MEDICAMENT_NOT_FOUND);
        }
        return MedicamentDto.fromEntity(
                medicamentRepository.findById(id).orElseThrow(
                        () -> new EntityNotFoundException("aucun medicament n'a été trouvé avec l'id "+id
                                , ErrorCodes.MEDECIN_NOT_FOUND)
                )
        );
    }

    @Override
    public List<MedicamentDto> findAll() {
        return medicamentRepository.findAll().stream()
                .map(MedicamentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

    }
}
