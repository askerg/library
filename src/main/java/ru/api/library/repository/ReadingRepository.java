package ru.api.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.api.library.model.Booking;
import ru.api.library.model.User;

import java.util.List;

@Repository
public interface ReadingRepository extends JpaRepository<Booking, Integer> {
	List<Booking> findByUser(User user);
}
