package com.solebac.credRapido.repositories.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solebac.credRapido.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	public Optional<Users> findByEmail(String email);
}
