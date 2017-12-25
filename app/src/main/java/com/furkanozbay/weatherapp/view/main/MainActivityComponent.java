package com.furkanozbay.weatherapp.view.main;

import com.furkanozbay.weatherapp.core.PerActivity;
import com.furkanozbay.weatherapp.core.AppComponent;
import dagger.Component;

/**
 * Created by Furkan on 24.12.2017.
 */

@PerActivity
@Component(dependencies = AppComponent.class, modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);

}