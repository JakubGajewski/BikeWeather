package pl.jakubgajewski.BikeWeather.models.utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public final class CheckUserInput {
    public static boolean checkIfInputIsText(String s) {
        if (Pattern.matches("[a-zA-Z]+",s)) {
            return true;
        }
        return false;
    }
}
