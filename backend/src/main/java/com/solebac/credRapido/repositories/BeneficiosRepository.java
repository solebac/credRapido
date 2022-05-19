package com.solebac.credRapido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solebac.credRapido.entities.Beneficios;

@Repository
public interface BeneficiosRepository extends JpaRepository<Beneficios, Long> {

}
