package com.grupo.projeto.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupo.projeto.dtos.BookDTO;
import com.grupo.projeto.model.BookModel;
import com.grupo.projeto.repository.BookRepository;
import com.grupo.projeto.service.exception.DataIntegratyViolationException;
import com.grupo.projeto.service.exception.ObjectNotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;
	
	@Transactional(readOnly = true)
	public List<BookModel> findAll() {
		List<BookModel> list = repository.findAll();
		if(list.isEmpty()) {
			throw new DataIntegratyViolationException("Não existe nenhum livro");
		}
		return list;
	}

	@Transactional(readOnly = true)
	public Page<Object> findAllPages(Pageable pageable) {
		repository.findAll();
		Page<BookModel> result = repository.findAll(pageable);
		return result.map(x -> new BookDTO(x));
	}

	@Transactional(readOnly = true)
	public ResponseEntity<BookModel> findById(Long id) {
		return repository.findById((long) id).map(
				resp -> ResponseEntity.ok(resp)).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + " não existe, Tipo: " + BookModel.class.getName()));
	}

	@Transactional(readOnly = true)
	public ResponseEntity<List<BookModel>> findByDescriptionTitle(String title) {
		List<BookModel> user = repository.findByDescriptionTitle(title);
		if(user.isEmpty()) {
			throw new DataIntegratyViolationException("Não existe nenhum livro com esse titulo");
		}
		return ResponseEntity.ok(user);
	}

	public ResponseEntity<BookModel> created(BookModel book) {
		return ResponseEntity.ok(repository.save(book));
	}

	public ResponseEntity<BookModel> update(BookModel updateBook) {
		return ResponseEntity.ok(repository.save(updateBook));
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

}
