package ru.api.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.api.library.model.Book;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
	Optional<Book> findByIsbn(String isbn);
}
