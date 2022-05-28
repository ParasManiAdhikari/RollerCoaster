package de.th_luebeck.swt2praktikum.repositories;

import de.th_luebeck.swt2praktikum.entities.Achterbahn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchterbahnRepository extends JpaRepository<Achterbahn, Long> {
     Achterbahn findByName(String name);

    void delete(Achterbahn achterbahn_delete);
}
