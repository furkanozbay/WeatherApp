package com.furkanozbay.weatherapp.view.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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

    @BindView(R.id.layout_content)
    LinearLayout layoutContent;

    @BindView(R.id.text_degree)
    TextView textDegree;

    @BindView(R.id.progressbar_loading)
    ProgressBar progressBarLoading;

    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void initDagger() {
        DaggerMainActivityComponent.builder()
                .appComponent(WeatherApp.getComponent(this))
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
    public void setDescription(String degree) {
        textDegree.setText(degree);
        progressBarLoading.setVisibility(View.GONE);
        layoutContent.setVisibility(View.VISIBLE);
    }
}
