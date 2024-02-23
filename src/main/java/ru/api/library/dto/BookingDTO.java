package ru.api.library.dto;

import lombok.Getter;
import ru.api.library.model.Booking;
import ru.api.library.utils.DateFormatter;

@Getter
public class BookingDTO {
	private final String isbn;
	private final String title;
	private final String author;
	private final String createdAt;

	public BookingDTO(Booking booking) {
		this.isbn = booking.getBook().getIsbn();
		this.title = booking.getBook().getTitle();
		this.author = booking.getBook().getAuthor();
		this.createdAt = DateFormatter.format(booking.getCreatedAt());
	}
}
