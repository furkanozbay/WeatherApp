package com.furkanozbay.weatherapp.view.main;


import com.furkanozbay.weatherapp.model.entity.Weather;
import com.furkanozbay.weatherapp.view.base.BaseView;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Furkan on 24.12.2017.
 */

public class MainActivityPresenterImpl implements MainActivityPresenter {

    MainActivityInteractor mainActivityInteractor;

    private MainActivityView view;
    private CompositeDisposable compositeDisposable;

    public MainActivityPresenterImpl(MainActivityInteractor mainActivityInteractor) {
        this.mainActivityInteractor = mainActivityInteractor;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getWeather(String cityId) {
        compositeDisposable.add(mainActivityInteractor.getWeather(cityId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Weather>>() {

                    @Override
                    public void onNext(List<Weather> weathers) {
                        if (weathers != null) {
                            view.setDescription(weathers.get(0).getDescription());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                }));
    }

    @Override
    public void setView(BaseView baseView) {
        view = (MainActivityView) baseView;
    }
}
