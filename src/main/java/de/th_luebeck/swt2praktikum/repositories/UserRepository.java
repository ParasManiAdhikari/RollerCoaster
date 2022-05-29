package de.th_luebeck.swt2praktikum.repositories;

import de.th_luebeck.swt2praktikum.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    /**
     * @author Baraa
     * Get a user by username from the database
     */
    User findByUserName(String name);
    /**
     * @author Baraa
     * Get a user by email from the database
     */
    User findByEmail(String email);

    //User findById(long id);

    void delete(User user_delete);

}
