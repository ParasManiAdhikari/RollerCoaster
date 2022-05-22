package de.th_luebeck.swt2praktikum.repositories;

import de.th_luebeck.swt2praktikum.entities.Achterbahn;
import org.springframework.data.repository.CrudRepository;

public interface AchterbahnRepository extends CrudRepository<Achterbahn, Long> {

    Achterbahn findByName(String name);

}
