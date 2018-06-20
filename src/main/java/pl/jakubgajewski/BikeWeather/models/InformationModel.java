package pl.jakubgajewski.BikeWeather.models;

public class InformationModel {
    private String cityName;
    private float longitude;
    private float latitude;
    private int temperature;
    private int pressure;
    private int humidity;
    private int clouds;
    private String weatherComment;
    private float airQualityIndex;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public String getWeatherComment() {
        return weatherComment;
    }

    public float getAirQualityIndex() {
        return airQualityIndex;
    }

    public void setAirQualityIndex(float airQualityIndex) {
        this.airQualityIndex = airQualityIndex;
    }

    public InformationModel(String cityName, float longitude, float latitude, int temperature, int pressure, int humidity, int clouds, String weatherComment, float airQualityIndex) {
        this.cityName = cityName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.clouds = clouds;
        this.weatherComment = weatherComment;
        this.airQualityIndex = airQualityIndex;
    }

    @Override
    public String toString() {
        return "InformationModel{" +
                "cityName='" + cityName + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", temperature=" + temperature +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", clouds=" + clouds +
                ", weatherComment='" + weatherComment + '\'' +
                ", airQualityIndex=" + airQualityIndex +
                '}';
    }

    public void setWeatherComment(String weatherComment) {
        this.weatherComment = weatherComment;
    }
}