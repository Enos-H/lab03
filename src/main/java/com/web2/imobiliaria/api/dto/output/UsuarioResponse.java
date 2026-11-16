package com.web2.imobiliaria.api.dto.output;

import com.web2.imobiliaria.domain.model.PerfilNome;

import java.util.Set;

public record UsuarioResponse(
        Integer id,
        String login,
        boolean ativo,
        Set<PerfilNome> perfis,
        Integer clienteId
) {
}
