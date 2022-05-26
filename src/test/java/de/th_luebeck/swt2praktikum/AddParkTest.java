package de.th_luebeck.swt2praktikum;

import de.th_luebeck.swt2praktikum.controllers.ParkController.ParkController;
import de.th_luebeck.swt2praktikum.controllers.ParkController.ParkInput;
import de.th_luebeck.swt2praktikum.controllers.registration.RegistrationController;
import de.th_luebeck.swt2praktikum.controllers.registration.RegistrationInput;
import de.th_luebeck.swt2praktikum.entities.Park;
import de.th_luebeck.swt2praktikum.entities.User;
import de.th_luebeck.swt2praktikum.repositories.ParkRepository;
import de.th_luebeck.swt2praktikum.repositories.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
@AutoConfigureMockMvc
@SpringBootTest
public class AddParkTest {

    @Autowired
    private ParkController parkController;

    @Autowired
    private ParkRepository parkRepository;

    @Autowired
    private MockMvc mock;

    /**
     *
     * A parameterized junit test is called here by using a csv file with the required input data.
     * The csv file is stored in the ./src/test/resources folder and contains the parameters below.
     * @param name the given username as String
     * @param email the given Email as String
     * @param address the given address as String
     * @param fax the given faxnumber as a string
     * @param telefon the given telefonnumber as String
     */
    @ParameterizedTest(name = "{index}:name: {0}, email: {1}, address: {2}, fax{3}, telefon: {4},")
    @CsvFileSource(resources = "/parktestinput.csv", numLinesToSkip = 1)
    @DisplayName("Add park test")
    public void testAddPark(String name,String email, String address, String fax, String telefon) {

        ParkInput parkInput = new ParkInput(name,email,address,fax,telefon);
        parkController.addPark(parkInput);
        Park newpark = parkRepository.findByEmail(parkInput.getEmail());
        assertNotNull(newpark);
        assertEquals(parkInput.getEmailadress(),newpark.getEmail());
        assertEquals(parkInput.getName(),newpark.getName());

    }
}
