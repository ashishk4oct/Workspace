package com.headfirst.observerpattern;

public class WeatherStation {
    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.5f);
        System.out.println("----------------------------------------------------------");
        weatherData.setMeasurements(82, 60, 29.5f);
        System.out.println("----------------------------------------------------------");
        weatherData.setMeasurements(76, 69, 34.5f);
        System.out.println("----------------------------------------------------------");
    }
}
