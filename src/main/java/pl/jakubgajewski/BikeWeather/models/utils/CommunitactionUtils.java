package pl.jakubgajewski.BikeWeather.models.utils;

import pl.jakubgajewski.BikeWeather.models.InformationModel;

public final class CommunitactionUtils {

    public static String hotAlert = "It's too hot for cycling, better stay at home!";
    public static String iceAlert = "Ice alert, better be careful!";

    public static String airQualityIndexCommunicate = "Air Quality Index: ";
    public static String heavyPollutionCommunicate = "\nAir outside is extremally polluted, stay inside, close all windows and turn on the air cleaner!";
    public static String moderatePollutionCommunicate = "\nThere is some pollution, it's hazard to cycle in this conditions";
    public static String smallPollutionCommunicate = "\nAir is clean, you can go outside!";
    public static String noPollutionInformationCommunicate = "\nWe are sorry, but we don't have any information about air pollution in that region!";

    public static String checkCyclingConditions(InformationModel informationModel) {
        StringBuilder cyclingConditions = new StringBuilder();
        cyclingConditions.append(checkPollutionLevel(informationModel.getAirQualityIndex()));
        cyclingConditions.append(checkTemperatureConditions(informationModel.getTemperature()));
        return (cyclingConditions.toString());
    }

    public static String checkTemperatureConditions(int temperature) {
        if (temperature > 303) {
            return hotAlert;
        } else if (temperature < 273) {
            return iceAlert;
        }
        return "";
    }
//TODO: below is not alert, move it to "data processing utils"
    public static String checkPollutionLevel(float airQualityIndex) {
        if (airQualityIndex > 75) {
            return airQualityIndexCommunicate + airQualityIndex + CommunitactionUtils.heavyPollutionCommunicate;
        } else if (airQualityIndex > 50) {
            return airQualityIndexCommunicate + airQualityIndex + moderatePollutionCommunicate;
        } else if (airQualityIndex == -1) {
            return airQualityIndexCommunicate + airQualityIndex + noPollutionInformationCommunicate;
        }
        return airQualityIndexCommunicate + airQualityIndex + smallPollutionCommunicate;
    }

    public static String procesData(InformationModel informationModel) {
        return ("City: " + informationModel.getCityName() + ", temperature: "
                + informationModel.getTemperatureInCelsius() + " *C, synoptic comment: "
                + informationModel.getWeatherComment());
    }
}
//TODO: missing warnings about intensive sun