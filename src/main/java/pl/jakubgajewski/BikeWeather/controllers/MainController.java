package pl.jakubgajewski.BikeWeather.controllers;

import pl.jakubgajewski.BikeWeather.models.InformationModel;
import pl.jakubgajewski.BikeWeather.models.Observer;
import pl.jakubgajewski.BikeWeather.models.services.RestService;
import pl.jakubgajewski.BikeWeather.models.utils.Alerts;
import pl.jakubgajewski.BikeWeather.views.Menu;

public class MainController implements Observer {
    private RestService restService = RestService.getInstance();
        private Menu menu;

    public MainController() {
        restService.registerObserver(this);
        menu = new Menu();
    }

    public void run() {
        String response;
        do {
            response = menu.getCityFromUser();
            restService.getInformation(response);
            } while (!response.equals("exit"));
    }

    @Override
    public void update(InformationModel informationModel) {
        menu.sendMessageToConsole(menu.informationText(informationModel));
        menu.sendMessageToConsole(Alerts.checkCyclingConditions(informationModel));
    }
}
