package com.grupo.projeto.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo.projeto.dtos.UserDTO;
import com.grupo.projeto.model.UserModel;
import com.grupo.projeto.service.UserService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
@Api(tags = "Controlador de USER", description = "Utilitario de Postagens")
public class UserController {

	@Autowired
	private UserService service;
	
	
	@GetMapping
	public ResponseEntity<List<UserModel>> findAll(){
		List<UserModel> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	/*
	 * Busca pelo ID
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserModel> findById(@PathVariable Long id){
		ResponseEntity<UserModel> obj = service.findById(id);
		return obj;
	}
	
	/*
	 * Busca pelo email
	 */
	@GetMapping(value = "/email/{email}")
	public ResponseEntity<Optional<UserModel>> findByEmail(@PathVariable String email) {
		ResponseEntity<Optional<UserModel>> obj = service.findByEmail(email);
		return obj;
	}
	
	//Criação dos usuarios
	@PostMapping("/register")
	public Optional<Object> create(@Valid @RequestBody UserModel usuario){
		Optional<Object> obj = service.createUser(usuario);
		return obj;
	}
		
	//Login
	@PostMapping("/auth")
	public ResponseEntity<?> Autentication(@Valid @RequestBody Optional<UserDTO> user){
		return service.logar(user).map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	/*
	 *Update passando todas as informações no body 
	 */
	@PutMapping
	public ResponseEntity<Object> Put(@Valid @RequestBody Optional<UserModel> usuario){
		Optional<?> obj = service.update(usuario);
		return ResponseEntity.ok(obj);
	}
	
	/*
	 * Deleta uma postagem
	 */
	@DeleteMapping("/{id}")
	public void Delete(@PathVariable Long id) {
		service.delete(id);
	}
}
