package pl.jakubgajewski.BikeWeather.models.utils;

import org.junit.jupiter.api.Test;
import pl.jakubgajewski.BikeWeather.models.InformationModel;

import static org.junit.jupiter.api.Assertions.*;

class AlertsTest {

    InformationModel informationModelTest = new InformationModel("Czyste miasto", 25, 25, 290, 1000, 44,56,"superowo", 40);

    @Test
    void checkCyclingConditions() {
        assertEquals(Alerts.checkCyclingConditions(informationModelTest), "Air Quality Index: 40.0\nAir is clean, you can go outside!");
    }

    @Test
    void checkTemperatureConditions() {
        assertEquals(Alerts.checkTemperatureConditions(305),"It's too hot for cycling, better stay at home!");
        assertEquals(Alerts.checkTemperatureConditions(105),"Ice alert, better be careful!");
    }

    @Test
    void checkPollutionLevel() {
        assertEquals(Alerts.checkPollutionLevel(65.0f),"Air Quality Index: 65.0\nThere is some pollution, it's hazard to cycle in this conditions");
        assertEquals(Alerts.checkPollutionLevel(80.0f),"Air Quality Index: 80.0\nAir outside is extremally polluted, stay inside, close all windows and turn on the cleaner!");

    }
}

