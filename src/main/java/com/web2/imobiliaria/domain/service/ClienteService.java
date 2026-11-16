package com.web2.imobiliaria.domain.service;

import com.web2.imobiliaria.domain.exception.EntidadeNaoEncontradaException;
import com.web2.imobiliaria.domain.exception.NegocioException;
import com.web2.imobiliaria.domain.model.Cliente;
import com.web2.imobiliaria.domain.repository.ClienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<Cliente> listar(String nome, Pageable pageable) {
        if (StringUtils.hasText(nome)) {
            return repository.findByNomeClienteContainingIgnoreCase(nome, pageable);
        }
        return repository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Cliente buscarOuFalhar(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Cliente não encontrado"));
    }

    @Transactional
    public Cliente salvar(Cliente cliente) {
        boolean cpfEmUso = cliente.getId() == null
                ? repository.existsByCpf(cliente.getCpf())
                : repository.existsByCpfAndIdNot(cliente.getCpf(), cliente.getId());

        if (cpfEmUso) {
            throw new NegocioException("Já existe um cliente cadastrado com este CPF");
        }

        return repository.save(cliente);
    }

    @Transactional
    public void remover(Integer id) {
        Cliente cliente = buscarOuFalhar(id);
        repository.delete(cliente);
    }
}
