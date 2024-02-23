package ru.api.library.model;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Tag(name = "Бронь")
@Data
@Entity
@Table(name = "bookings")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_book")
	private Book book;

	@Column(name = "created_at")
	private Date createdAt;
}
