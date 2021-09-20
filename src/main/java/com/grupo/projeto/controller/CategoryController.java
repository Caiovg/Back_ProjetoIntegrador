package com.grupo.projeto.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.grupo.projeto.model.CategoryModel;
import com.grupo.projeto.service.CategoryService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
@Api(tags = "Controlador de CATEGORY", description = "Utilitario de Postagens")
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<CategoryModel>> findAll(){
		List<CategoryModel> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	/*
	 * Busca pelo ID
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoryModel> findById(@PathVariable Long id){
		ResponseEntity<CategoryModel> obj = service.findById(id);
		return obj;
	}
	
	/*
	 * Busca pelo genero
	 */
	@GetMapping(value = "/genre/{genre}")
	public ResponseEntity<List<CategoryModel>> findByGenre(@PathVariable String genre) {
		ResponseEntity<List<CategoryModel>> obj = service.findByDescriptionGenre(genre);
		return obj;
	}
	
	@PostMapping
	public ResponseEntity<CategoryModel> post(@Valid @RequestBody CategoryModel category) {
		ResponseEntity<CategoryModel> obj = service.created(category);
		return obj;
	}

	@PutMapping
	public ResponseEntity<CategoryModel> update(@Valid @RequestBody CategoryModel updateCategory) {
		ResponseEntity<CategoryModel> obj = service.update(updateCategory);
		return obj;
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		service.delete(id);
	}
}
