package pl.jakubgajewski.BikeWeather.models.utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.jakubgajewski.BikeWeather.models.InformationModel;

import static org.junit.jupiter.api.Assertions.*;

class CommunitactionUtilsTest {

    @BeforeAll
    static void zupa() {
        System.out.println("Zaraz będą testy alertów!");
    }

    InformationModel informationModelTest = new InformationModel("Czyste miasto", 25, 25, 290, 1000, 44,56,"superowo", 40);

    @Test
    void checkCyclingConditions() {
        assertEquals(CommunitactionUtils.checkCyclingConditions(informationModelTest), "Air Quality Index: 40.0\nAir is clean, you can go outside!");
    }

    @Test
    void checkTemperatureConditions() {
        assertEquals(CommunitactionUtils.checkTemperatureConditions(305),CommunitactionUtils.hotAlert);
        assertEquals(CommunitactionUtils.checkTemperatureConditions(105),CommunitactionUtils.iceAlert);
    }

    @Test
    void checkPollutionLevel() {
        assertEquals(CommunitactionUtils.checkPollutionLevel(65.0f),CommunitactionUtils.airQualityIndexCommunicate + "65.0" + CommunitactionUtils.moderatePollutionCommunicate);
        assertEquals(CommunitactionUtils.checkPollutionLevel(80.0f),CommunitactionUtils.airQualityIndexCommunicate + "80.0" + CommunitactionUtils.heavyPollutionCommunicate);
        assertEquals(CommunitactionUtils.checkPollutionLevel(-1.0f),CommunitactionUtils.noPollutionInformationCommunicate);

    }

    @AfterAll
    static void zupka() {
        System.out.println("To by było na tyle z alertów!");
    }
}

