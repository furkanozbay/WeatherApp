package com.furkanozbay.weatherapp.view.main;


import com.furkanozbay.weatherapp.model.entity.Weather;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Furkan on 24.12.2017.
 */

public interface MainActivityInteractor {

    Observable<List<Weather>> getWeather(String cityId);
}
