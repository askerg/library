package ru.api.library.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.api.library.controller.request.AssignBookRequest;
import ru.api.library.controller.request.CreateUserRequest;
import ru.api.library.dto.UserDTO;
import ru.api.library.model.User;
import ru.api.library.service.UserService;

import java.util.List;

@Tag(name = "Пользователи")
@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
	private final UserService service;

	@GetMapping
	public List<UserDTO> getAll() {
		return service.getAll(UserDTO::new);
	}

	@GetMapping("/{id}")
	public UserDTO getById(@PathVariable Integer id) {
		User user = service.getById(id);
		return new UserDTO(user);
	}

	@PostMapping
	public UserDTO create(@RequestBody CreateUserRequest request) {
		User user = service.create(
			request.getFirstName(),
			request.getLastName(),
			request.getMiddleName(),
			request.getBirthDate()
		);
		return new UserDTO(user);
	}

	@PostMapping("/assign")
	public UserDTO addBooks(@RequestBody AssignBookRequest request) {
		User user = service.assignBook(request.getUserId(), request.getIsbn());
		return new UserDTO(user);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Integer id) {
		service.delete(id);
	}
}
