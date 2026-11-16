package com.web2.imobiliaria.api.dto.output;

import com.web2.imobiliaria.domain.model.PerfilNome;

public record PerfilResponse(
        Integer id,
        PerfilNome nome
) {
}
