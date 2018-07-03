package pl.jakubgajewski.BikeWeather.models.utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckUserInputTest {

    @BeforeAll
    static void zupa () {
        System.out.println("A teraaaaaz testy juser inputów!");
    }

    @Test
    void checkIfInputIsText() {

        assertFalse(CheckUserInput.checkIfInputIsText("16"));
        assertTrue(CheckUserInput.checkIfInputIsText("ddawdaa"));
        assertFalse(CheckUserInput.checkIfInputIsText("ddawdaa!"));
    }

    @AfterAll
    static void zupka () {
        System.out.println("Inputy również obtestowane!");
    }
}