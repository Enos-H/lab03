package com.web2.imobiliaria.domain.repository;

import com.web2.imobiliaria.domain.model.Perfil;
import com.web2.imobiliaria.domain.model.PerfilNome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {

    Optional<Perfil> findByNome(PerfilNome nome);

    List<Perfil> findAllByOrderByNomeAsc();
}
