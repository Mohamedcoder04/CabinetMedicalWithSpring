package com.gestion.cabinetmedical.services.implimantation;

import com.gestion.cabinetmedical.dto.SecretaireDto;
import com.gestion.cabinetmedical.exceptions.EntityNotFoundException;
import com.gestion.cabinetmedical.exceptions.ErrorCodes;
import com.gestion.cabinetmedical.exceptions.InvalidEntityException;
import com.gestion.cabinetmedical.repositories.SecretaireRepository;
import com.gestion.cabinetmedical.services.SecretaireService;
import com.gestion.cabinetmedical.validator.SecretaireValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service @Slf4j
public class SecretaireServiceImpl implements SecretaireService {
    private SecretaireRepository secretaireRepository;

    @Autowired
    public SecretaireServiceImpl(SecretaireRepository secretaireRepository) {
        this.secretaireRepository = secretaireRepository;
    }

    @Override
    public SecretaireDto save(SecretaireDto dto) {
        List<String> errors = SecretaireValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("secretaire n'est pas valid {}", dto);
            throw new InvalidEntityException("le secretaire que vous avez saisi n'est pas valide",errors, ErrorCodes.SECRETAIRE_NOT_VALID);
        }

        return SecretaireDto.fromEntity(
                secretaireRepository.save(SecretaireDto.toEntity(dto))
        );
    }

    @Override
    public SecretaireDto findById(Integer id) {
        if(id == null){

        }

        return SecretaireDto.fromEntity(
                secretaireRepository.findById(id).orElseThrow(
                        ()-> new EntityNotFoundException("aucun secretaire n'a été trouvé avec l'id "+id , ErrorCodes.SECRETAIRE_NOT_FOUND)
                )
        );
    }

    @Override
    public SecretaireDto findByEmail(String email) {
        if(email == null){
            log.error("l'Email est null");
            throw new InvalidEntityException("l'email que vous avez saisi est null ", ErrorCodes.SECRETAIRE_NOT_VALID);
        }
        return SecretaireDto.fromEntity(
                secretaireRepository.findByEmail(email).orElseThrow(
                        ()-> new EntityNotFoundException("aucun secretaire n'a été trouvé avec cet eamil", ErrorCodes.SECRETAIRE_NOT_FOUND )
                )
        );
    }

    @Override
    public List<SecretaireDto> findAll() {
        return secretaireRepository.findAll().stream()
                .map(SecretaireDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

    }
}
