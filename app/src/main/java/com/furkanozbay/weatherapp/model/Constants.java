package com.furkanozbay.weatherapp.model;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.furkanozbay.weatherapp.model.Constants.API_KEY;
import static com.furkanozbay.weatherapp.model.Constants.CITY_ID;

/**
 * Created by Furkan on 24.12.2017.
 */

@StringDef({CITY_ID, API_KEY})
@Retention(RetentionPolicy.SOURCE)
public @interface Constants {

    String CITY_ID = "745042";
    String API_KEY = "b60dffe71b473be382d814ac7fc1e6c0";
}
