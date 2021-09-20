package com.grupo.projeto.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.grupo.projeto.repository.UserRepository;
import com.grupo.projeto.model.UserModel;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		// ou findByUsuario
		Optional<UserModel> user = repository.findByEmail(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + "email não encontrado!"));
		return user.map(UserDetailsImpl :: new).get();
	}
}
