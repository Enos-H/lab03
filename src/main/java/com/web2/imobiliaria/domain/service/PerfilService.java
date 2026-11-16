package com.web2.imobiliaria.domain.service;

import com.web2.imobiliaria.domain.model.Perfil;
import com.web2.imobiliaria.domain.repository.PerfilRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PerfilService {

    private final PerfilRepository repository;

    public PerfilService(PerfilRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Perfil> listar() {
        return repository.findAllByOrderByNomeAsc();
    }
}
