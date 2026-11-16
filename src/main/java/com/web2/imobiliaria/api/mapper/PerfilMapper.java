package com.web2.imobiliaria.api.mapper;

import com.web2.imobiliaria.api.dto.output.PerfilResponse;
import com.web2.imobiliaria.domain.model.Perfil;
import org.springframework.stereotype.Component;

@Component
public class PerfilMapper {

    public PerfilResponse paraResponse(Perfil perfil) {
        return new PerfilResponse(perfil.getId(), perfil.getNome());
    }
}
