package de.th_luebeck.swt2praktikum;

import de.th_luebeck.swt2praktikum.controllers.Achterbahn.AchterbahnController;
import de.th_luebeck.swt2praktikum.controllers.Achterbahn.AchterbahnInput;
import de.th_luebeck.swt2praktikum.entities.Achterbahn;
import de.th_luebeck.swt2praktikum.repositories.AchterbahnRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class Achterbahn_Anzeigen_Test {

    @Autowired
    private AchterbahnRepository achterbahnRepository;

    /**
     *
     * A parameterized junit test is called here by using a csv file with the required input data.
     * The csv file is stored in the ./src/test/resources folder and contains the parameters below.
     * @param name the given name as String
     */
    @ParameterizedTest(name = "{index}:name: {0}")
    @CsvFileSource(resources = "/AchterbahnAnzeigenInput.csv", numLinesToSkip = 1)
    @DisplayName("Achterbahn AnzeigenInput instantiation test")
    public void achterbahnAnzeigenTest(String name){
        Achterbahn achterbahnInput = new Achterbahn(name);
        Achterbahn savedAchterbahn =  achterbahnRepository.save(achterbahnInput);
        assertNotNull(savedAchterbahn);

        List<Achterbahn> achterbahns = achterbahnRepository.findAll();
        assertNotEquals(0, achterbahns.size());

    }
}
