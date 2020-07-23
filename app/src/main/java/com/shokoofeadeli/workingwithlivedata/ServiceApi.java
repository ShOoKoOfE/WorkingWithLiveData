package com.shokoofeadeli.workingwithlivedata;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ServiceApi {

  @GET("services.php")
  Call<ArrayList<Product>> GetProductList(@QueryMap HashMap<String, String> map);

}
