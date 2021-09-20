package com.grupo.projeto.dtos;

import com.grupo.projeto.model.BookModel;

public class BookDTO {

		private long idProduct;
		private String title;
		private String description;
		private Double price;
		private String author;
		private int year;
		private int inventory;
		private String language;
		private long isbn;
		private long ean;
		private String country;
		private String publisher;
		private String format;
		private int pages;
		private CategoryDTO category;
		
		public BookDTO() {}

		public BookDTO(long idProduct, String title, String description, Double price, String author, int year,
				int inventory, String language, long isbn, long ean, String country, String publisher, String format,
				int pages, CategoryDTO category) {
			super();
			this.idProduct = idProduct;
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
		}
		
		public BookDTO(BookModel entity) {
			super();
			idProduct = entity.getIdProduct();
			title = entity.getTitle();
			description = entity.getDescription();
			price = entity.getPrice();
			author = entity.getAuthor();
			year = entity.getYear();
			inventory = entity.getInventory();
			language = entity.getLanguage();
			isbn = entity.getIsbn();
			ean = entity.getEan();
			country = entity.getCountry();
			publisher = entity.getPublisher();
			format = entity.getFormat();
			pages = entity.getPages();
			this.category = new CategoryDTO(entity.getCategory());
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

		public CategoryDTO getCategory() {
			return category;
		}

		public void setCategory(CategoryDTO category) {
			this.category = category;
		}
}
