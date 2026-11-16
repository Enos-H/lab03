package com.web2.imobiliaria.domain.repository;

import com.web2.imobiliaria.domain.model.Locacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Integer> {

    @Query("""
            select l from Locacao l
            where (:clienteId is null or l.inquilino.id = :clienteId)
              and (:ativo is null or l.ativo = :ativo)
              and (:nomeInquilino is null or lower(l.inquilino.nomeCliente) like lower(concat('%', cast(:nomeInquilino as string), '%')))
            """)
    Page<Locacao> buscar(@Param("clienteId") Integer clienteId,
                         @Param("nomeInquilino") String nomeInquilino,
                         @Param("ativo") Boolean ativo,
                         Pageable pageable);

    @Query("""
            select (count(l) > 0) from Locacao l
            where l.imovel.id = :imovelId
              and l.ativo = true
              and l.dataInicio <= :dataFim
              and l.dataFim >= :dataInicio
              and (:ignorarId is null or l.id <> :ignorarId)
            """)
    boolean existeSobreposicao(@Param("imovelId") Integer imovelId,
                               @Param("dataInicio") LocalDate dataInicio,
                               @Param("dataFim") LocalDate dataFim,
                               @Param("ignorarId") Integer ignorarId);
}
