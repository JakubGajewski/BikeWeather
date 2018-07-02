package pl.jakubgajewski.BikeWeather.models.utils;

import java.util.Arrays;

public final class ConverterUtils {
    public static int convertKelvinsToCelsius(int temperaureInK) {
        int temperatureInC = temperaureInK - 273;
        return temperatureInC;
    }
}


