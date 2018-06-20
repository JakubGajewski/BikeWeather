package pl.jakubgajewski.BikeWeather.models.utils;

import pl.jakubgajewski.BikeWeather.models.services.ApiKeys;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class RestUtils {
    public static String readWebsiteContent(String url) {

        StringBuilder stringBuilder = new StringBuilder();

        try {
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
            InputStream content = urlConnection.getInputStream();

            int read = 0;
            while ((read = content.read()) != -1) {
                stringBuilder.append((char) read);
            }
            content.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static String readWebsiteContentWithHeader(String url, String headerKey, String headerValue) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestProperty(headerKey, headerValue);
            con.setRequestMethod("GET");

            InputStream content = con.getInputStream();

            int read = 0;
            while ((read = content.read()) != -1) {
                stringBuilder.append((char) read);
            }
            content.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
