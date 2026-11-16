package com.web2.imobiliaria.api.mapper;

import com.web2.imobiliaria.api.dto.output.UsuarioResponse;
import com.web2.imobiliaria.domain.model.Perfil;
import com.web2.imobiliaria.domain.model.PerfilNome;
import com.web2.imobiliaria.domain.model.Usuario;
import org.springframework.stereotype.Component;

import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    public UsuarioResponse paraResponse(Usuario usuario) {
        Set<PerfilNome> perfis = usuario.getPerfis().stream()
                .map(Perfil::getNome)
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(PerfilNome.class)));

        Integer clienteId = usuario.getCliente() == null ? null : usuario.getCliente().getId();

        return new UsuarioResponse(
                usuario.getId(),
                usuario.getLogin(),
                usuario.isAtivo(),
                perfis,
                clienteId
        );
    }
}
