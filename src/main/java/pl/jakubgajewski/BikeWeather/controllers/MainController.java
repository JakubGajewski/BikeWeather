package pl.jakubgajewski.BikeWeather.controllers;

import pl.jakubgajewski.BikeWeather.models.InformationModel;
import pl.jakubgajewski.BikeWeather.models.Observer;
import pl.jakubgajewski.BikeWeather.models.services.RestService;
import pl.jakubgajewski.BikeWeather.models.utils.Alerts;
import pl.jakubgajewski.BikeWeather.models.utils.DataProcessingUtils;
import pl.jakubgajewski.BikeWeather.views.UserInterface;

public class MainController implements Observer {
    private RestService restService = RestService.getInstance();
    private UserInterface userInterface;

    public MainController() {
        restService.registerObserver(this);
        userInterface = new UserInterface();
    }

    public void run() {
        userInterface.sayHello();
        String response = userInterface.getFirstCityFromUser();

        while (!response.equals("")) {
            restService.getInformation(response);
            response = userInterface.getNextCityFromUser();
        }
        userInterface.sayGoodbye();
    }

    @Override
    public void update(InformationModel informationModel) {
        userInterface.sendMessageToConsole(DataProcessingUtils.procesData(informationModel));
        userInterface.sendMessageToConsole(Alerts.checkCyclingConditions(informationModel));
        userInterface.sendMessageToConsole("\n");
    }
}
