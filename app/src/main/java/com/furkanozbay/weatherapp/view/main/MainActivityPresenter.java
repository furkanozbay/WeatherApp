package com.furkanozbay.weatherapp.view.main;

import com.furkanozbay.weatherapp.view.base.BasePresenter;

/**
 * Created by Furkan on 24.12.2017.
 */

public interface MainActivityPresenter extends BasePresenter {

    void getWeather(String cityId);
}
