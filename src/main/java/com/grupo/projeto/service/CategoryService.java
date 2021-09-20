package com.grupo.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupo.projeto.model.CategoryModel;
import com.grupo.projeto.repository.CategoryRepository;
import com.grupo.projeto.service.exception.DataIntegratyViolationException;
import com.grupo.projeto.service.exception.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	@Transactional(readOnly = true)
	public List<CategoryModel> findAll() {
		List<CategoryModel> list = repository.findAll();
		if(list.isEmpty()) {
			throw new DataIntegratyViolationException("Não existe nenhuma categoria");
		}
		return list;
	}

	@Transactional(readOnly = true)
	public ResponseEntity<CategoryModel> findById(Long id) {
		return repository.findById((long) id).map(
				resp -> ResponseEntity.ok(resp)).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + " não existe, Tipo: " + CategoryModel.class.getName()));
	}

	@Transactional(readOnly = true)
	public ResponseEntity<List<CategoryModel>> findByDescriptionGenre(String genero) {
		List<CategoryModel> user = repository.findByDescriptionGenre(genero);
		if(user.isEmpty()) {
			throw new DataIntegratyViolationException("Não existe nenhuma categoria com esse nome");
		}
		return ResponseEntity.ok(user);
	}

	public ResponseEntity<CategoryModel> created(CategoryModel category) {
		return ResponseEntity.ok(repository.save(category));
	}

	public ResponseEntity<CategoryModel> update(CategoryModel updateCategory) {
		return ResponseEntity.ok(repository.save(updateCategory));
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
}
