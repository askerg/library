package ru.api.library.dto;

import lombok.Getter;
import ru.api.library.model.User;
import ru.api.library.utils.DateFormatter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UserDTO {
	private final String fullName;
	private final String birthDate;
	private final List<BookingDTO> books;

	public UserDTO(User user) {
		this.fullName = String.format("%s %s %s",
			user.getLastName(),
			user.getFirstName(),
			user.getMiddleName()
		);
		this.birthDate = DateFormatter.format(user.getBirthDate());
		this.books = user.getBooks().stream()
			.map(BookingDTO::new)
			.collect(Collectors.toList());
	}
}
