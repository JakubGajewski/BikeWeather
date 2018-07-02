package pl.jakubgajewski.BikeWeather.views;

import pl.jakubgajewski.BikeWeather.models.InformationModel;

import java.util.Scanner;

import static java.lang.System.in;

public class UserInterface {
    Scanner sc = new Scanner(in);

    public void sayHello() {
        System.out.println("Welcome to BikeWeather app!");
        System.out.println("Would you like to check conditions for your next bicycle trip?\n");
        System.out.println("To leave the program, leave the field blank and type \"enter\"\n");
    }

    public void sayGoodbye() {
        System.out.println("Goodbye my friend! I hope you come back some day!");
    }

    public String getFirstCityFromUser() {
        System.out.println("Please type the name of your city:");
        System.out.println();
        return (sc.nextLine());
    }

    public String getNextCityFromUser() {
        System.out.println("Data is downloading! If you want, you can type another city name");
        System.out.println();
        return (sc.nextLine());
    }

    public void sendMessageToConsole(String message) {
        System.out.println(message);
    }
}