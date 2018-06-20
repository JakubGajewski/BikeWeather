package pl.jakubgajewski.BikeWeather.models.utils;

import java.util.Arrays;

public final class InformationProcessingUtils {
    public static int convertToCelsiusDegrees (int temperaureInK) {
        int temperatureInC = temperaureInK - 273;
        return temperatureInC;
    }
}


