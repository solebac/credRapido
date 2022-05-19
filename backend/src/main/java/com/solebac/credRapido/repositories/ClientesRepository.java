package com.solebac.credRapido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solebac.credRapido.entities.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long>{

}
