package de.th_luebeck.swt2praktikum;

import de.th_luebeck.swt2praktikum.controllers.Achterbahn.AchterbahnController;
import de.th_luebeck.swt2praktikum.entities.Achterbahn;
import de.th_luebeck.swt2praktikum.repositories.AchterbahnRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@AutoConfigureMockMvc
@SpringBootTest
public class SuchenTest {
    @Autowired
    private AchterbahnController achterbahnController;

    @Autowired
    private AchterbahnRepository achterbahnRepository;

    @Autowired
    private MockMvc mock;



    @Test
    @DisplayName("Suchen Achterbahn test")
    public void suchenTest(){

        List<Achterbahn> _achterbahns = achterbahnRepository.findAll().stream().filter(a -> a.getName().toLowerCase().
                contains("rt".toLowerCase())
        ).collect(Collectors.toList());
        assertNotNull(_achterbahns);
        assertEquals(2, _achterbahns.size());
    }
}
