package com.headfirst.observerpattern;

public class CurrentConditionsDisplay implements Observer, DisplayElements {

    private float temperature;
    private float humidity;
    private Subject weatherData;

    public  CurrentConditionsDisplay(Subject weatherData){
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current condition "+temperature+" F degree and "+humidity+" % humidity");
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
}
