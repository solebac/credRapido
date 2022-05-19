package com.solebac.credRapido.services.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.solebac.credRapido.entities.Users;
import com.solebac.credRapido.repositories.security.UsersRepository;

@Service
public class ServicesAutenticacao implements UserDetailsService{

	@Autowired
	private UsersRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// A senha é check pelo spring em memória
		
		Optional<Users> usuario = repository.findByEmail(username);
		if (usuario.isPresent()) {
			return usuario.get();
		}
		throw new UsernameNotFoundException("Dados inválidos...!");
	}
	
}
