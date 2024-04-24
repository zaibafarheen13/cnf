package com.zaiba_lab3And4.lab3And4;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	private final List<Book> books=new ArrayList<>();
	private Long bookIdCounter=1L;
	
	@GetMapping
	public List<Book> getAllBooks(){
		return books;
	}
	
	@PostMapping
	public Book addBook(@RequestBody Book book) {
		book.setId(generateBookIdCounter());
		books.add(book);
		return book;
	}
	
	@GetMapping("/{id}")
	public Book getBook(@PathVariable Long id){
		return findBookById(id);
	}
	
	public Book findBookById(@PathVariable Long id) {
		for(Book book:books) {
			if(book.getId().equals(id)) {
				return book;
			}
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id){
		Book rb=findBookById(id);
		if(rb!=null) {
			books.remove(rb);
		}
	}
	
	@PutMapping("/{id}")
	public Book updateBook(@PathVariable Long id,@RequestBody Book book) {
		Book eb=findBookById(id);
		if(eb!=null) {
			eb.setBook_title(book.getBook_title());
			eb.setBook_author(book.getBook_author());
			eb.setBook_publicationYear(book.getBook_publicationYear());
		}
		return eb;
	}
	
	public Long generateBookIdCounter(){
		return bookIdCounter++;
	}
	

}
