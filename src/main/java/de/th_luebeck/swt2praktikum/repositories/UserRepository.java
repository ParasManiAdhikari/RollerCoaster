package de.th_luebeck.swt2praktikum.repositories;

import de.th_luebeck.swt2praktikum.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByName(String name);

}
