package pl.jakubgajewski.BikeWeather.models.utils;

import static org.junit.jupiter.api.Assertions.*;

class ConverterUtilsTest {
    @org.junit.jupiter.api.Test
    void convertKelvinsToCelsius() {
        assertEquals(ConverterUtils.convertKelvinsToCelsius(293), 20);
        assertEquals(ConverterUtils.convertKelvinsToCelsius(200), -73);
        assertEquals(ConverterUtils.convertKelvinsToCelsius(-200), -473);
    }

}