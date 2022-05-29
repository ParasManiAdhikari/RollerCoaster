package de.th_luebeck.swt2praktikum;

import de.th_luebeck.swt2praktikum.controllers.ParkController.ParkController;
import de.th_luebeck.swt2praktikum.controllers.UserController;
import de.th_luebeck.swt2praktikum.entities.Achterbahn;
import de.th_luebeck.swt2praktikum.entities.Park;
import de.th_luebeck.swt2praktikum.repositories.ParkRepository;
import de.th_luebeck.swt2praktikum.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ParkControllerTest {

    @Autowired
    private static ParkController parkController;
    private static ParkRepository mockedParkRepository;
    private static BindingResult mockedBindingResult;
    private static Model mockedModel;

    @BeforeEach
    public void setUpUserControllerInstance() {
        mockedParkRepository = mock(ParkRepository.class);
        mockedBindingResult = mock(BindingResult.class);
        mockedModel = mock(Model.class);
        parkController = new ParkController(mockedParkRepository);
    }


    @Test
    void showParkTest(){
        Park park = new Park("Dumbo Park", "dumbo@gmail.com", "Sierksdorf 19", "+32435", "+3252342525");
        mockedParkRepository.save(park);
        when(mockedBindingResult.hasErrors()).thenReturn(false);
        assertThat(parkController.showParks(mockedModel)).isEqualTo("parks");
    }

    public static void main(String[] args) {
        Park park3 = new Park("Dumbo Park", "dumbo@gmail.com", "Sierksdorf 19", "+32435", "+3252342525");
        Park park4 = new Park("Cumbo Park", "cumbo@gmail.com", "Sierksdorf 19", "+32435", "+3252342525");
        mockedParkRepository.save(park3);
    }

}