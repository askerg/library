package ru.api.library.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.api.library.exception.ApiError;
import ru.api.library.model.Book;
import ru.api.library.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {
	private final BookRepository repository;

	@Transactional(readOnly = true)
	public List<Book> getAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public Book getByIsbn(String isbn) {
		return repository.findByIsbn(isbn)
			.orElseThrow(ApiError.BookNotFound::new);
	}

	@Transactional
	public Book create(String isbn, String title, String author) {
		Optional<Book> book = repository.findById(isbn);
		if (book.isPresent()) {
			throw new ApiError.BookAlreadyExists();
		}

		Book newBook = new Book();
		newBook.setIsbn(isbn);
		newBook.setTitle(title);
		newBook.setAuthor(author);

		return repository.save(newBook);
	}

	@Transactional
	public void delete(String isbn) {
		Optional<Book> book = repository.findById(isbn);
		if (!book.isPresent()) {
			throw new ApiError.BookNotFound();
		}
		repository.delete(book.get());
	}
}
