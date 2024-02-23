package ru.api.library.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.api.library.controller.request.CreateBookRequest;
import ru.api.library.model.Book;
import ru.api.library.service.BookService;

import java.util.List;

@Tag(name = "Книги")
@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController {
	private final BookService service;

	@GetMapping
	public List<Book> getAll() {
		return service.getAll();
	}

	@GetMapping("/{isbn}")
	public Book getByIsbn(@PathVariable String isbn) {
		return service.getByIsbn(isbn);
	}

	@PostMapping
	public Book create(@RequestBody CreateBookRequest request) {
		return service.create(
			request.getIsbn(),
			request.getTitle(),
			request.getAuthor()
		);
	}

	@DeleteMapping("/{isbn}")
	public void deleteByIsbn(@PathVariable String isbn) {
		service.delete(isbn);
	}
}
