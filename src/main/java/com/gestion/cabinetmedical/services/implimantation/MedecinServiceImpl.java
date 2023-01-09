package com.gestion.cabinetmedical.services.implimantation;

import com.gestion.cabinetmedical.dto.MedecinDto;
import com.gestion.cabinetmedical.exceptions.EntityNotFoundException;
import com.gestion.cabinetmedical.exceptions.ErrorCodes;
import com.gestion.cabinetmedical.exceptions.InvalidEntityException;
import com.gestion.cabinetmedical.repositories.MedecinRepository;
import com.gestion.cabinetmedical.services.MedecinService;
import com.gestion.cabinetmedical.validator.ConsultationValidator;
import com.gestion.cabinetmedical.validator.MedecinValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service @Slf4j
public class MedecinServiceImpl implements MedecinService {

    private MedecinRepository medecinRepository;

    @Autowired
    public MedecinServiceImpl(MedecinRepository medecinRepository) {
        this.medecinRepository = medecinRepository;
    }

    @Override
    public MedecinDto save(MedecinDto dto) {
        List<String> errors = MedecinValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("le medecin {} que vous avez saisi n'est pas valid", dto);
            throw new InvalidEntityException("vous avez saisi un medcin invalid" ,errors,  ErrorCodes.MEDECIN_NOT_VALID);
        }
        return MedecinDto.fromEntity(
                medecinRepository.save(
                        MedecinDto.toEntity(dto)
                )
        );
    }

    @Override
    public MedecinDto findById(Integer id) {
        if(id == null){
            log.warn("");
            throw new EntityNotFoundException("", ErrorCodes.MEDECIN_NOT_FOUND);
        }
        return MedecinDto.fromEntity(
                medecinRepository.findById(id).orElseThrow(
                        ()-> new EntityNotFoundException("aucun medecin n'a été trouvé avec l'ID"+id, ErrorCodes.MEDECIN_NOT_FOUND)
                )
        );
    }

    @Override
    public List<MedecinDto> findAll() {
        return medecinRepository.findAll().stream()
                .map(MedecinDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

    }
}
