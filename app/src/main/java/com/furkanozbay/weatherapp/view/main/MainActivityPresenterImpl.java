package com.furkanozbay.weatherapp.view.main;


import com.furkanozbay.weatherapp.model.entity.Weather;
import com.furkanozbay.weatherapp.view.base.BaseView;

import java.util.List;

import javax.inject.Inject;

import dagger.Provides;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Furkan on 24.12.2017.
 */

public class MainActivityPresenterImpl implements MainActivityPresenter {

    @Inject
    MainActivityInteractor interactor;

    private MainActivityView view;

    @Inject
    public MainActivityPresenterImpl() {
    }

    @Override
    public void getWeather(String cityId) {
        interactor.getWeather(cityId)
                .subscribe(new Observer<List<Weather>>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Weather> weathers) {
                        if (weathers != null) {
                            view.setDegree(weathers.get(0).getDescription());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void setView(BaseView baseView) {
        view = (MainActivityView) baseView;
    }
}
