package pl.jakubgajewski.BikeWeather.views;

import pl.jakubgajewski.BikeWeather.models.InformationModel;

import java.util.Scanner;

import static java.lang.System.in;

public class Menu {
    Scanner sc = new Scanner(in);

    public void menu() {
        System.out.println("Welcome to BikeWeather app!");
        System.out.println("Would you like to check conditions for your next bicycle trip?");
    }

    public String getCityFromUser() {
        System.out.println("Please type in the name of your city:");
        System.out.println();
        return (sc.nextLine());
    }

    public String informationText(InformationModel informationModel) {
        return ("City: "
                + informationModel.getCityName()
                + "; temperature: "
                + informationModel.getTemperature()
                + "; cloudy: "
                + informationModel.getClouds()
                + "; comments: "
                + informationModel.getWeatherComment())
                + "; air quality index: "
                + informationModel.getAirQualityIndex();
    }

    public void cleanConsole(int lines) {
        for (int i = 0; i < lines; i++) {
            System.out.println();
        }
    }

    public void sendMessageToConsole(String message) {
        System.out.println(message);
    }
}