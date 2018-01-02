package com.furkanozbay.weatherapp.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by Furkan on 23.12.2017.
 */

public class WeatherApp extends Application implements HasActivityInjector {

    private AppComponent appComponent;

    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }

    public AppComponent getComponent() {
        return appComponent;
    }

    public static AppComponent getComponent(Context context) {
        return ((WeatherApp) context.getApplicationContext()).getComponent();
    }
}
