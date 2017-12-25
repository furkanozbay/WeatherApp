package com.furkanozbay.weatherapp.view.main;

import android.widget.TextView;

import com.furkanozbay.weatherapp.R;
import com.furkanozbay.weatherapp.core.WeatherApp;
import com.furkanozbay.weatherapp.model.Constants;
import com.furkanozbay.weatherapp.view.base.BaseActivity;
import com.furkanozbay.weatherapp.view.base.BasePresenter;
import com.furkanozbay.weatherapp.view.base.BaseView;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainActivityView {

    @BindView(R.id.text_degree)
    TextView textDegree;

    @Inject
    MainActivityPresenterImpl presenter;

    @Override
    protected void initDagger() {
        DaggerMainActivityComponent.builder()
                .appComponent(WeatherApp.getComponent(this))
                .mainActivityModule(new MainActivityModule())
                .build()
                .inject(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void attachView() {
        presenter.getWeather(Constants.CITY_ID);
    }

    @Override
    public BasePresenter getPresenter() {
        return presenter;
    }

    @Override
    public BaseView getView() {
        return this;
    }

    @Override
    public void setDegree(String degree) {
        textDegree.setText(degree);
    }
}
