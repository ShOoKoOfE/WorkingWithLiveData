package com.shokoofeadeli.workingwithlivedata;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
  public static final String API_BASE_URL = "http://169.254.131.120/online-shop/";
  //http://192.168.3.247/online-shop/
  //http://192.168.125.2/online-shop/
  //http://169.254.131.120/online-shop/


  public static <S> S createService(Class<S> serviceClass) {
    OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder();
    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    logging.setLevel(HttpLoggingInterceptor.Level.BODY);
    httpClient = new OkHttpClient.Builder();
    httpClient.addInterceptor(logging);

    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    OkHttpClient client = httpClient.build();
    Retrofit retrofit = builder.client(client).build();
    return retrofit.create(serviceClass);
  }
}

