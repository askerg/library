package ru.api.library.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.api.library.exception.ApiError;
import ru.api.library.model.Booking;
import ru.api.library.model.User;
import ru.api.library.repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
	private final UserRepository repository;
	private final BookingService bookingService;

	@Transactional(readOnly = true)
	public <T> List<T> getAll(Function<User, T> mapper) {
		return getAll().stream()
			.map(mapper)
			.collect(Collectors.toList());
	}

	public List<User> getAll() {
		List<User> users = repository.findAll();

		users.forEach(this::getAssignedBooks);

		return users;
	}

	@Transactional(readOnly = true)
	public User getById(Integer id) {
		User user = repository.findById(id)
			.orElseThrow(ApiError.UserNotFound::new);

		getAssignedBooks(user);

		return user;
	}

	@Transactional
	public User create(String firstName, String lastName, String middleName, Date birthDate) {
		// проверять по ФИО и дате бесполезно,
		// был бы паспорт какой-нибудь, тогда можно было бы проверит на уникальность
		User user = new User();

		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setMiddleName(middleName);
		user.setBirthDate(birthDate);

		return repository.save(user);
	}

	@Transactional
	public void delete(Integer id) {
		Optional<User> user = repository.findById(id);
		if (!user.isPresent()) {
			throw new ApiError.UserNotFound();
		}
		repository.delete(user.get());
	}

	@Transactional
	public User assignBook(Integer userId, String isbn) {
		User user = repository.findById(userId)
			.orElseThrow(ApiError.UserNotFound::new);

		bookingService.create(user, isbn, new Date());

		return getById(userId);
	}

	private void getAssignedBooks(User user) {
		List<Booking> books = bookingService.getAllByUserId(user);
		user.setBooks(books);
	}
}
