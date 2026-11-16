package com.web2.imobiliaria.domain.repository;

import com.web2.imobiliaria.domain.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Integer> {
}
