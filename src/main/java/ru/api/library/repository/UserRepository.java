package ru.api.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.api.library.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
