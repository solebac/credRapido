package com.solebac.credRapido.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solebac.credRapido.controllers.dto.LoginForm;
import com.solebac.credRapido.entities.Users;

@RestController
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	private AuthenticationManager manager;
	
	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm form) {
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		try {
			Authentication authenticate = manager.authenticate(dadosLogin);
			SecurityContextHolder.getContext().setAuthentication(authenticate);
			Users obj = (Users) authenticate.getPrincipal();
			return ResponseEntity.ok().body(obj);	
		}catch (BadCredentialsException be) {

	        System.out.println(be.getLocalizedMessage() + "\n------");
	        System.out.println(be.getStackTrace() + "\n------");
	        System.out.println(be.getMessage() + "\n------");
	        System.out.println(be.getCause() + "\n------");
	        return ResponseEntity.badRequest().build();

	    }
		catch (AuthenticationException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
		
	}
}
