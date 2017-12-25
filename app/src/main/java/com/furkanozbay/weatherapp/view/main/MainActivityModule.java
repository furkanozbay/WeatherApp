package com.furkanozbay.weatherapp.view.main;

import com.furkanozbay.weatherapp.core.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Furkan on 24.12.2017.
 */

@Module
@PerActivity
public class MainActivityModule {

    @Provides
    MainActivityPresenterImpl provideMainActivityPresenter() {
        return new MainActivityPresenterImpl();
    }

    @Provides
    MainActivityInteractor provideMainActivityInteractor() {
        return new MainActivityInteractorImpl();
    }
}
