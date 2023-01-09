package com.gestion.cabinetmedical.services.implimantation;

import com.gestion.cabinetmedical.dto.MedecinDto;
import com.gestion.cabinetmedical.dto.RendezVousDto;
import com.gestion.cabinetmedical.dto.SecretaireDto;
import com.gestion.cabinetmedical.exceptions.EntityNotFoundException;
import com.gestion.cabinetmedical.exceptions.ErrorCodes;
import com.gestion.cabinetmedical.exceptions.InvalidEntityException;
import com.gestion.cabinetmedical.repositories.MedecinRepository;
import com.gestion.cabinetmedical.repositories.RendezVousRepository;
import com.gestion.cabinetmedical.repositories.SecretaireRepository;
import com.gestion.cabinetmedical.services.RendezVousService;
import com.gestion.cabinetmedical.validator.RendezVousValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service @Slf4j
public class RendezVousServiceImpl implements RendezVousService {
    private MedecinRepository medecinRepository;
    private SecretaireRepository secretaireRepository;
    private RendezVousRepository rendezVousRepository;

    @Autowired
    public RendezVousServiceImpl(MedecinRepository medecinRepository, SecretaireRepository secretaireRepository, RendezVousRepository rendezVousRepository) {
        this.medecinRepository = medecinRepository;
        this.secretaireRepository = secretaireRepository;
        this.rendezVousRepository = rendezVousRepository;
    }

    @Override
    public RendezVousDto save(RendezVousDto dto) {
        List<String> errors = RendezVousValidator.validate(dto);

        if(!errors.isEmpty()){
            log.error("rendez-vous n'est pas valid");
            throw new InvalidEntityException("rendez vous que vous avez saisi n'est pas valid",
                    ErrorCodes.RENDEZVOUS_NOT_VALID);
        }

        MedecinDto medecinDto = MedecinDto.fromEntity(
                medecinRepository.findById(dto.getMedecin().getId()).orElseThrow(
                        () -> new EntityNotFoundException("aucun medecin n'a été trouve avec l'ID "+ dto.getMedecin().getId(),
                                ErrorCodes.MEDECIN_NOT_FOUND)
                )
        );

        SecretaireDto secretaireDto = SecretaireDto.fromEntity(
                secretaireRepository.findById(dto.getSecretaire().getId()).orElseThrow(
                        ()-> new EntityNotFoundException("aucun secretaire n'a été trouvé avec l'ID "+ dto.getSecretaire().getId(),
                                ErrorCodes.SECRETAIRE_NOT_FOUND)
                )
        );
        return RendezVousDto.fromEntity(
                rendezVousRepository.save(
                        RendezVousDto.toEntity(dto)
                )
        );
    }

    @Override
    public RendezVousDto findById(Integer id) {
        if(id == null){
            log.warn("");
            throw new EntityNotFoundException("l'id est NULL", ErrorCodes.RENDEZVOUS_NOT_FOUND);
        }
        return RendezVousDto.fromEntity(
                rendezVousRepository.findById(id).orElseThrow(
                        ()-> new EntityNotFoundException("aucun rendez vous n'a été trouvé avec l'id "+id,
                                ErrorCodes.RENDEZVOUS_NOT_FOUND)
                )
        );
    }

    @Override
    public List<RendezVousDto> findAll() {
        return rendezVousRepository.findAll().stream()
                .map(RendezVousDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

    }
}
