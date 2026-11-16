package com.web2.imobiliaria.api.controller;

import com.web2.imobiliaria.api.dto.output.PerfilResponse;
import com.web2.imobiliaria.api.mapper.PerfilMapper;
import com.web2.imobiliaria.domain.service.PerfilService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/perfis")
@Tag(name = "Perfis", description = "Consulta dos perfis de acesso disponíveis (ADMIN)")
@PreAuthorize("hasRole('ADMIN')")
public class PerfilController {

    private final PerfilService service;
    private final PerfilMapper mapper;

    public PerfilController(PerfilService service, PerfilMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<PerfilResponse> lista() {
        return service.listar().stream().map(mapper::paraResponse).toList();
    }
}
