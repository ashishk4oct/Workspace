package com.headfirst.observerpattern.java;

import com.headfirst.observerpattern.DisplayElements;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElements {

    private float temperature;
    private float humidity;
    private Observable weatherData;

    public CurrentConditionsDisplay(Observable weatherData){
        this.weatherData = weatherData;
        this.weatherData.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current condition "+temperature+" F degree and "+humidity+" % humidity");
    }

    @Override
    public void update(Observable observable, Object arg) {
        if(observable instanceof WeatherData){
            WeatherData weatherData = (WeatherData)observable;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
