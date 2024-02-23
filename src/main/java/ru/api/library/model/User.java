package ru.api.library.model;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Tag(name = "Пользователь")
@Data
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String firstName;
	private String lastName;
	private String middleName;

	@Column(name = "date_of_birth")
	private Date birthDate;

	@Transient
	private List<Booking> books = new ArrayList<>();
}
