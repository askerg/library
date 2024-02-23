package ru.api.library.controller.request;

import lombok.Data;

@Data
public class AssignBookRequest {
	private Integer userId;
	private String isbn;
}
