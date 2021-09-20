package com.grupo.projeto.dtos;

import com.grupo.projeto.model.CategoryModel;

public class CategoryDTO {

	private long idCategory;
	private String genre;
	
	public CategoryDTO() {}

	public CategoryDTO(long idCategory, String genre) {
		super();
		this.idCategory = idCategory;
		this.genre = genre;
	}
	
	public CategoryDTO(CategoryModel entity) {
		super();
		idCategory = entity.getIdCategory();
		genre = entity.getGenre();
	}

	public long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(long idCategory) {
		this.idCategory = idCategory;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
