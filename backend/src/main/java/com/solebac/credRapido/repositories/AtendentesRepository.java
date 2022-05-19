package com.solebac.credRapido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solebac.credRapido.entities.Atendentes;

@Repository
public interface AtendentesRepository extends JpaRepository<Atendentes, Integer>{

}
