package pl.jakubgajewski.BikeWeather.models.utils;

import pl.jakubgajewski.BikeWeather.models.InformationModel;

public final class Alerts {

    public static String checkCyclingConditions(InformationModel informationModel) {
        StringBuilder cyclingConditions = new StringBuilder();
        cyclingConditions.append(checkPollutionLevel(informationModel.getAirQualityIndex()));
        cyclingConditions.append(checkTemperatureConditions(informationModel.getTemperature()));

        return (cyclingConditions.toString());
    }

    public static String checkTemperatureConditions(int temperature) {
        if (temperature > 303) {
            return "It's too hot for cycling, better stay at home!";
        } else if (temperature < 273) {
            return "Ice alert, better be careful!";
        }
        return "";
    }
//TODO: below is not alert, move it to "data processing utils"
    public static String checkPollutionLevel(float airQualityIndex) {
        if (airQualityIndex > 75) {
            return "Air Quality Index: " + airQualityIndex + "\nAir outside is extremally polluted, stay inside, close all windows and turn on the cleaner!";
        } else if (airQualityIndex > 50) {
            return "Air Quality Index: " + airQualityIndex + "\nThere is some pollution, it's hazard to cycle in this conditions";
        } else if (airQualityIndex == -1) {
            return "We are sorry, but we don't have any information about air pollution in that region!";
        }
        return "Air Quality Index: " + airQualityIndex + "\nAir is clean, you can go outside!";
    }
}
//TODO: missing warnings about intensive sun