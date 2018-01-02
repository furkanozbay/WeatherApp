package com.furkanozbay.weatherapp.network;

import com.furkanozbay.weatherapp.model.response.WeatherResponse;


import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Furkan on 23.12.2017.
 */

public interface WeatherService {

    @POST("data/2.5/weather")
    Observable<WeatherResponse> getWeather(@Query("id") String cityId);
}
