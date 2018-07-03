package pl.jakubgajewski.BikeWeather.models.services;

import org.json.JSONArray;
import org.json.JSONObject;

import pl.jakubgajewski.BikeWeather.models.InformationModel;
import pl.jakubgajewski.BikeWeather.models.utils.RestUtils;
import pl.jakubgajewski.BikeWeather.models.Observer;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RestService {

    private static RestService ourInstance = new RestService();

    public static RestService getInstance() {
        return ourInstance;
    }

    private RestService() {
        observerList = new ArrayList<>();
        executorService = Executors.newSingleThreadExecutor();
    }

    private ExecutorService executorService;
    private List<Observer> observerList;

    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    public void getInformation(final String city) {

        executorService.execute(() -> {
            String weatherResponse = RestUtils.readWebsiteContent("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + ApiKeys.weatherApiKey);
            float latitude;
            float longitude;
            //OpenWeatherMap API needs only city name, but for Airly API we need coordinates, which are taken from OpenWeather response
            String description = null;
            int temperature;
            int pressure;
            int humidity;
            int clouds;
            float airQualityIndex;

            JSONObject rootWeatherResponse = new JSONObject(weatherResponse);

            JSONObject coordObject = rootWeatherResponse.getJSONObject("coord");
            longitude = coordObject.getFloat("lon");
            latitude = coordObject.getFloat("lat");

            JSONArray weatherObject = rootWeatherResponse.getJSONArray("weather");
            for (int i = 0; i < weatherObject.length(); i++) {
                JSONObject elementInArray = weatherObject.getJSONObject(i);
                description = elementInArray.getString("main");
            }

            JSONObject mainObject = rootWeatherResponse.getJSONObject("main");
            temperature = (int) mainObject.getFloat("temp");
            pressure = mainObject.getInt("pressure");
            humidity = mainObject.getInt("humidity");

            JSONObject cloudsObject = rootWeatherResponse.getJSONObject("clouds");
            clouds = cloudsObject.getInt("all");

            String airlyResponse = RestUtils.readWebsiteContentWithHeader("https://airapi.airly.eu/v1/mapPoint/measurements?latitude=" + latitude + "&longitude=" + longitude, "apikey", ApiKeys.pollutionApiKey);
            JSONObject rootAirlyResponse = new JSONObject(airlyResponse);

            try {
                JSONObject currentMeasurementsObject = rootAirlyResponse.getJSONObject("currentMeasurements");
                airQualityIndex = (float) currentMeasurementsObject.getFloat("airQualityIndex");
            } catch (Exception E) {
                airQualityIndex = -1;
                //Airly has some bugs and very often response is not available
            }
            InformationModel informationModel = new InformationModel(city, latitude, longitude, temperature, humidity, pressure, clouds, description, airQualityIndex);

            try {Thread.sleep(2000);
                //Just a simulation of lot-of=data downloading process - to see if it works in different thread
            } catch (InterruptedException IE) {
                System.out.println("Iterrupted exception, the thread is interrupted!");
            }

            notifyObservers(informationModel);
        });
    }

    private void notifyObservers(InformationModel informationModel) {
        for (Observer observer : observerList) {
            observer.update(informationModel);
        }
    }

    public List getObserverList() {     ////////method used only in tests
        return this.observerList;                               ////////
    }
}