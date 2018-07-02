package pl.jakubgajewski.BikeWeather.models.utils;

import pl.jakubgajewski.BikeWeather.models.InformationModel;

public final class DataProcessingUtils {
    public static String procesData(InformationModel informationModel) {
        return ("City: " + informationModel.getCityName() + ", temperature: "
                + informationModel.getTemperatureInCelsius() + " *C, synoptic comment: "
                + informationModel.getWeatherComment());
    }
}
