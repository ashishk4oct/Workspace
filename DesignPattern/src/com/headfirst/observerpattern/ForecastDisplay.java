package com.headfirst.observerpattern;

public class ForecastDisplay implements Observer, DisplayElements {

    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public ForecastDisplay(Subject weatherData){
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Forecast "+temperature+" F degree,"+humidity+" % humidity and "+ pressure+" psi");
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}