package ru.api.library.controller.request;

import lombok.Data;

@Data
public class CreateBookRequest {
	private String isbn;
	private String title;
	private String author;
}
