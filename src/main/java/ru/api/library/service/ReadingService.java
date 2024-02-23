package ru.api.library.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.api.library.model.Book;
import ru.api.library.model.Booking;
import ru.api.library.model.User;
import ru.api.library.repository.ReadingRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReadingService {
	private final ReadingRepository repository;
	private final BookService bookService;

	@Transactional(readOnly = true)
	public List<Booking> getAllByUserId(User user) {
		return repository.findByUser(user);
	}

	@Transactional
	public Booking create(User user, String isbn, Date creationDate) {
		Booking booking = new Booking();

		Book book = bookService.getByIsbn(isbn);

		booking.setBook(book);
		booking.setUser(user);
		booking.setCreatedAt(creationDate);

		return repository.save(booking);
	}
}
