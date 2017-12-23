package com.furkanozbay.weatherapp.core;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Furkan on 23.12.2017.
 */

@Singleton
@Component(modules = AppModule.class)
interface AppComponent {
    void inject(WeatherApp weatherApp);
}