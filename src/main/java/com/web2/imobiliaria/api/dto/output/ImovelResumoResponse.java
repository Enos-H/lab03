package com.web2.imobiliaria.api.dto.output;

public record ImovelResumoResponse(
        Integer id,
        String tipoImovel,
        String endereco
) {
}
