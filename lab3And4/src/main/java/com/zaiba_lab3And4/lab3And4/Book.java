package com.zaiba_lab3And4.lab3And4;

public class Book {
	
	Long id;
	
	String book_title,book_author;
	int book_publicationYear;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public int getBook_publicationYear() {
		return book_publicationYear;
	}
	public void setBook_publicationYear(int book_publicationYear) {
		this.book_publicationYear = book_publicationYear;
	}
	

}
