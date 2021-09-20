package com.grupo.projeto.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.grupo.projeto.model.BookModel;
import com.grupo.projeto.service.BookService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin("*")
@RequestMapping("/book")
@Api(tags = "Controlador de BOOK", description = "Utilitario de Postagens")
public class BookController {

	@Autowired
	private BookService service;
	
	@GetMapping
	public ResponseEntity<List<BookModel>> findAll(){
		List<BookModel> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/pages")
	public ResponseEntity<Page<Object>> findAll(Pageable pageable){
		Page<Object> list = service.findAllPages(pageable);
		return ResponseEntity.ok(list);
	}
	
	/*
	 * Busca pelo ID
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<BookModel> findById(@PathVariable Long id){
		ResponseEntity<BookModel> obj = service.findById(id);
		return obj;
	}
	
	/*
	 * Busca pelo titulo do livro
	 */
	@GetMapping(value = "/title/{title}")
	public ResponseEntity<List<BookModel>> findByBook(@PathVariable String title) {
		ResponseEntity<List<BookModel>> obj = service.findByDescriptionTitle(title);
		return obj;
	}
	
	@PostMapping
	public ResponseEntity<BookModel> post(@Valid @RequestBody BookModel category) {
		ResponseEntity<BookModel> obj = service.created(category);
		return obj;
	}

	@PutMapping
	public ResponseEntity<BookModel> update(@Valid @RequestBody BookModel updateCategory) {
		ResponseEntity<BookModel> obj = service.update(updateCategory);
		return obj;
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		service.delete(id);
	}
}
