package com.furkanozbay.weatherapp.view.base;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.DispatchingAndroidInjector;

public abstract class BaseActivity extends AppCompatActivity {

    protected BaseView view;
    protected BasePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initDagger();
        attachView();
        view = getView();
        presenter = getPresenter();
        presenter.setView(view);
    }

    protected abstract void initDagger();

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    public abstract int getLayoutId();

    public abstract void attachView();

    public abstract BasePresenter getPresenter();

    public abstract BaseView getView();
}
