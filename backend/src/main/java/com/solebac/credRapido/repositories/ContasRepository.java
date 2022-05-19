package com.solebac.credRapido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solebac.credRapido.entities.Conta;

@Repository
public interface ContasRepository extends JpaRepository<Conta, Long> {

}
