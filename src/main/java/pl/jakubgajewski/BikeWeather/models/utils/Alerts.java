package pl.jakubgajewski.BikeWeather.models.utils;

import pl.jakubgajewski.BikeWeather.models.InformationModel;

public final class Alerts {


    public static String checkCyclingConditions(InformationModel informationModel) {
        StringBuilder cyclingConditions = new StringBuilder();
        cyclingConditions.append(checkTemperatureConditions(informationModel.getTemperature()));
        return ("Suggestion: " + cyclingConditions);
    }



    public static String checkTemperatureConditions(int temperature) {
        if (temperature > 15) {
            return "It's too hot for cycling, better stay home!";
        }
        return null;
    }
}
