package com.solebac.credRapido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solebac.credRapido.entities.Servicos;

@Repository
public interface ServicosRepository extends JpaRepository<Servicos, Long> {

}
