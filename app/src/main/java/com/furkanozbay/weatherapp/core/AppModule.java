package com.furkanozbay.weatherapp.core;

import android.content.Context;

import dagger.Module;
import dagger.android.AndroidInjectionModule;

/**
 * Created by Furkan on 23.12.2017.
 */

@Module
public class AppModule {

    private Context context;

    AppModule(Context context) {
        this.context = context;
    }
}
