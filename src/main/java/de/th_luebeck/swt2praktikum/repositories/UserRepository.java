package de.th_luebeck.swt2praktikum.repositories;

import de.th_luebeck.swt2praktikum.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * @author Baraa
     * Get a user by username from the database
     */
    User findByName(String name);
    /**
     * @author Baraa
     * Get a user by email from the database
     */
    User findByEmail(String email);
}
