package com.furkanozbay.weatherapp.network;

import com.furkanozbay.weatherapp.model.Constants;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Furkan on 24.12.2017.
 */

public class ApiClient {

    public static final String BASE_URL = "http://api.openweathermap.org/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(chain -> {
                        Request original = chain.request();
                        HttpUrl httpUrl = original.url();

                        HttpUrl newHttpUrl = httpUrl.newBuilder().addQueryParameter("APPID",
                                Constants.API_KEY).build();

                        Request.Builder requestBuilder = original.newBuilder().url(newHttpUrl);

                        Request request = requestBuilder.build();
                        return chain.proceed(request);
                    }).addInterceptor(chain -> {
                        Request request = chain.request();
                        Response response = chain.proceed(request);
                        return response;
                    }).build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
