package com.gestion.cabinetmedical.security.authentication;

import com.gestion.cabinetmedical.dto.SecretaireDto;
import com.gestion.cabinetmedical.services.SecretaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private SecretaireService secretaireService;

    @Autowired
    public AppUserDetailsService(SecretaireService secretaireService) {
        this.secretaireService = secretaireService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        SecretaireDto secretaireDto = secretaireService.findByEmail(email);
        List<GrantedAuthority> authorities = new ArrayList<>();

        return new User(secretaireDto.getEmail() , secretaireDto.getPassword(), authorities);
    }
}
