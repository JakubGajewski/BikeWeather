package pl.jakubgajewski.BikeWeather.models.services;

import org.junit.jupiter.api.Test;
import pl.jakubgajewski.BikeWeather.controllers.MainController;

import static org.junit.jupiter.api.Assertions.*;

class RestServiceTest {
    RestService restServiceTest = RestService.getInstance();
    MainController mainControllerTest = new MainController();

    @Test
    void registerObserver() {
        restServiceTest.registerObserver(mainControllerTest);
        assertEquals(restServiceTest.getObserverList().get(0),mainControllerTest);
    }

    @Test
    void getInformation() {
    }
}