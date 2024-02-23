package ru.api.library.controller.request;

import lombok.Data;

import java.util.Date;

@Data
public class CreateUserRequest {
	private String firstName;
	private String lastName;
	private String middleName;
	private Date birthDate;
}
