package com.furkanozbay.weatherapp.network;

import com.furkanozbay.weatherapp.model.Constants;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
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
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request original = chain.request();
                            HttpUrl httpUrl = original.url();

                            HttpUrl newHttpUrl = httpUrl.newBuilder().addQueryParameter("APPID",
                                    Constants.API_KEY).build();

                            Request.Builder requestBuilder = original.newBuilder().url(newHttpUrl);

                            Request request = requestBuilder.build();
                            return chain.proceed(request);
                        }
                    }).build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
