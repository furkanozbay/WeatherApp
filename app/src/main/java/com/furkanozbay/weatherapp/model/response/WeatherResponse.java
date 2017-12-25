package com.furkanozbay.weatherapp.model.response;

/**
 * Created by Furkan on 24.12.2017.
 */

import com.furkanozbay.weatherapp.model.entity.Weather;

import java.util.List;

public class WeatherResponse {

    private List<Weather> weather;

    public List<Weather> getWeatherList() {
        return weather;
    }
}

