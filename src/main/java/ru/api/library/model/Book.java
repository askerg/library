package ru.api.library.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Schema(title = "Книга")
@Data
@Entity
@Table(name = "books")
public class Book {
	@Id
	@Size(min = 13, max = 13, message = "ISBN должен состоять из 13 символов")
	private String isbn;

	private String title;

	private String author;
}
