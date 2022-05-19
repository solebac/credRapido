package com.solebac.credRapido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solebac.credRapido.entities.Banco;

@Repository
public interface BancosRepository extends JpaRepository<Banco, Long>{

}
