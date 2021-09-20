package com.grupo.projeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_book")
public class BookModel {

	//attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProduct;

	@NotBlank(message = "Informe o título")
	private String title;

	@Column(length = 100000)
	@NotBlank(message = "Insira uma descrição")
	private String description;

	@NotNull(message = "Informe o valor do livro")
	private Double price;

	@NotBlank(message = "Insira o nome do autor")
	private String author;

	@NotNull(message = "Insira o ano de publicação")
	private int year;

	@NotNull(message = "Informe a quantidade do estoque")
	private int inventory;
		
	@NotBlank
	private String language;
		
	@NotNull
	private long isbn;
		
	@NotNull
	private long ean;
		
	@NotBlank(message = "Informe o País")
	private String country;
		
	@NotBlank(message = "Informe a Editora")
	private String publisher;

	@NotBlank(message = "Informe o Formato")
	private String format;
		
	@NotNull(message = "Informe a quantidade páginas")
	private int pages;
		
	@ManyToOne
	@JoinColumn(name = "IdCategory")
	@JsonIgnoreProperties({"book"})
	private CategoryModel category;
	
	@ManyToOne
	@JoinColumn(name = "IdClient")
	@JsonIgnoreProperties({"book"})
	private UserModel users;

	public BookModel() {}

	public BookModel(String title, String description,
			Double price, String author, int year,
			int inventory, String language, long isbn, 
			long ean, String country, String publisher,
			String format, int pages, CategoryModel category, UserModel users) {
		
		this.title = title;
		this.description = description;
		this.price = price;
		this.author = author;
		this.year = year;
		this.inventory = inventory;
		this.language = language;
		this.isbn = isbn;
		this.ean = ean;
		this.country = country;
		this.publisher = publisher;
		this.format = format;
		this.pages = pages;
		this.category = category;
		this.users = users;
	}

	public long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public long getEan() {
		return ean;
	}

	public void setEan(long ean) {
		this.ean = ean;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}

	public UserModel getUsers() {
		return users;
	}

	public void setUsers(UserModel users) {
		this.users = users;
	}

}
