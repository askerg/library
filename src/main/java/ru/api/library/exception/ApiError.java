package ru.api.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.NotNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public abstract class ApiError extends RuntimeException {

	@Message("Пользователь не найден")
	public static class UserNotFound extends ApiError {}

	@Message("Книга не найдена")
	public static class BookNotFound extends ApiError {}

	@Message("Книга уже существует")
	public static class BookAlreadyExists extends ApiError {}

	@Retention(RetentionPolicy.RUNTIME)
	public @interface Message {
		String value();
	}

	@NotNull
	@Override
	public String getMessage() {
		return this.getClass().getAnnotation(Message.class).value();
	}
}
