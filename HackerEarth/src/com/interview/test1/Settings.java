package com.interview.test1;

public class Settings {

    private static Settings settings ;
    private Settings(){

    }

    static Settings getInstance(){
        if(null == settings){
            synchronized(Settings.class){
                if(null == settings) {
                    settings = new Settings();
                }
            }
        }
        return settings;
    }
}
