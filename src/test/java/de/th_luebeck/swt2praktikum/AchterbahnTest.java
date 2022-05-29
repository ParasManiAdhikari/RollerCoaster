package de.th_luebeck.swt2praktikum;

import de.th_luebeck.swt2praktikum.controllers.Achterbahn.AchterbahnController;
import de.th_luebeck.swt2praktikum.controllers.Achterbahn.AchterbahnInput;
import de.th_luebeck.swt2praktikum.entities.Achterbahn;
import de.th_luebeck.swt2praktikum.repositories.AchterbahnRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@AutoConfigureMockMvc
@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class AchterbahnTest {

    @Autowired
    private AchterbahnController achterbahnController;

    @Autowired
    private AchterbahnRepository achterbahnRepository;

    @Autowired
    private MockMvc mock;

    @ParameterizedTest(name = "Test {index} with {0}")
    @CsvFileSource(resources = "/achterbahnTestInput.csv", numLinesToSkip = 1)
    @DisplayName("Add Achterbahn test")
    public void addAchterbahnTest(String name) {
        AchterbahnInput achterbahnInput = new AchterbahnInput(name);
        achterbahnController.addAchterbahn(achterbahnInput);
        Achterbahn savedAchterbahn = achterbahnRepository.findByName(achterbahnInput.getName());
        assertNotNull(savedAchterbahn);
        assertEquals(achterbahnInput.getName(), savedAchterbahn.getName());
    }

}
