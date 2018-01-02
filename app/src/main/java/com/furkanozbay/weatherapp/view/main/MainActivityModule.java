package com.furkanozbay.weatherapp.view.main;

import com.furkanozbay.weatherapp.core.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Furkan on 24.12.2017.
 */

@PerActivity
@Module
public class MainActivityModule {

    @Provides
    MainActivityPresenter provideMainActivityPresenter(MainActivityInteractorImpl mainActivityInteractor) {
        return new MainActivityPresenterImpl(mainActivityInteractor);
    }

    @Provides
    MainActivityInteractor provideMainActivityInteractor() {
        return new MainActivityInteractorImpl();
    }
}
