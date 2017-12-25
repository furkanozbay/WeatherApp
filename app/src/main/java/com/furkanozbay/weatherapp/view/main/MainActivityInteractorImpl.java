package com.furkanozbay.weatherapp.view.main;

import com.furkanozbay.weatherapp.model.entity.Weather;
import com.furkanozbay.weatherapp.network.ApiClient;
import com.furkanozbay.weatherapp.network.WeatherService;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Furkan on 24.12.2017.
 */

public class MainActivityInteractorImpl implements MainActivityInteractor {

    @Override
    public Observable<List<Weather>> getWeather(String cityId) {
        WeatherService weatherService = ApiClient.getClient().create(WeatherService.class);

        return weatherService.getWeather(cityId)
                .switchMap(response -> Observable.just(response.getWeatherList()));
    }
}
