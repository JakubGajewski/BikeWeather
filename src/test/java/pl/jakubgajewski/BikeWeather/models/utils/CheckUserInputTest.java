package pl.jakubgajewski.BikeWeather.models.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckUserInputTest {

    @Test
    void checkIfInputIsText() {

        assertEquals(CheckUserInput.checkIfInputIsText("16"), false);
        assertEquals(CheckUserInput.checkIfInputIsText("ddawdaa"), true);
        assertEquals(CheckUserInput.checkIfInputIsText("ddawdaa!"), false);
    }
}