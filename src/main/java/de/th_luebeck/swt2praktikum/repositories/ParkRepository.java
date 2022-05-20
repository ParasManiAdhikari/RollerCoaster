package de.th_luebeck.swt2praktikum.repositories;

import de.th_luebeck.swt2praktikum.entities.Park;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkRepository extends JpaRepository<Park, Long> {
    /**
     * @author Baraa
     * Get a park by name from the database
     */
    Park findByName(String name);
    /**
     * @author Baraa
     * Get a park by email from the database
     */
    Park findByEmail(String email);

    void delete(Park park_delete);
}