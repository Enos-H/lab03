package com.web2.imobiliaria.domain.repository;

import com.web2.imobiliaria.domain.model.Aluguel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Integer> {

    @Query("""
            select a from Aluguel a
            where (:locacaoId is null or a.locacao.id = :locacaoId)
              and (:clienteId is null or a.locacao.inquilino.id = :clienteId)
            """)
    Page<Aluguel> buscar(@Param("locacaoId") Integer locacaoId,
                         @Param("clienteId") Integer clienteId,
                         Pageable pageable);
}
