package com.web2.imobiliaria.api.dto.output;

import java.time.LocalDate;

public record ClienteResponse(
        Integer id,
        String nomeCliente,
        String cpf,
        String telefone,
        String email,
        LocalDate dtNascimento
) {
}
