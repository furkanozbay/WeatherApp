package com.furkanozbay.weatherapp.view.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.furkanozbay.weatherapp.R;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    public abstract int getLayoutId();
}
