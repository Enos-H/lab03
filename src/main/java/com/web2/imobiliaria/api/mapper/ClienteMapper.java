package com.web2.imobiliaria.api.mapper;

import com.web2.imobiliaria.api.dto.input.ClienteRequest;
import com.web2.imobiliaria.api.dto.output.ClienteResponse;
import com.web2.imobiliaria.api.dto.output.ClienteResumoResponse;
import com.web2.imobiliaria.domain.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente paraEntidade(ClienteRequest request) {
        Cliente cliente = new Cliente();
        atualizarEntidade(cliente, request);
        return cliente;
    }

    public void atualizarEntidade(Cliente cliente, ClienteRequest request) {
        cliente.setNomeCliente(request.nomeCliente());
        cliente.setCpf(request.cpf());
        cliente.setTelefone(request.telefone());
        cliente.setEmail(request.email());
        cliente.setDtNascimento(request.dtNascimento());
    }

    public ClienteResponse paraResponse(Cliente cliente) {
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNomeCliente(),
                cliente.getCpf(),
                cliente.getTelefone(),
                cliente.getEmail(),
                cliente.getDtNascimento()
        );
    }

    public ClienteResumoResponse paraResumo(Cliente cliente) {
        return new ClienteResumoResponse(cliente.getId(), cliente.getNomeCliente());
    }
}
