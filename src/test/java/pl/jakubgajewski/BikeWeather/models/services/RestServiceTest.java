package pl.jakubgajewski.BikeWeather.models.services;

import org.junit.jupiter.api.Test;
import pl.jakubgajewski.BikeWeather.controllers.MainController;
import pl.jakubgajewski.BikeWeather.models.InformationModel;

import static org.junit.jupiter.api.Assertions.*;

class RestServiceTest {
    RestService restServiceTest = RestService.getInstance();


    @Test
    void registerObserver() {
        MainController mainControllerTest = new MainController();
        restServiceTest.registerObserver(mainControllerTest);
        assertEquals(restServiceTest.getObserverList().get(0),mainControllerTest);
    }

    @Test
    void notifyObservers() {
        InformationModel informationModelTest = new InformationModel("Wrocław", 50, 50, 20, 50, 7, 7, "Superowo", 47.0f);
        restServiceTest.getInformation("Wrocław");

        //TODO: test!
    }

    @Test
    void getInformation() {
        //TODO: test!
    }
}