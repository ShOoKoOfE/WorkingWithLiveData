package com.shokoofeadeli.workingwithlivedata;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepository {
    private ArrayList<Product> products = new ArrayList<>();
    private MutableLiveData<ArrayList<Product>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public ProductRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<ArrayList<Product>> getMutableLiveData() {
        HashMap<String,String> map = new HashMap<>();
        map.put("action","product");
        map.put("filter","1 = 1");
        map.put("sort","ASC");
        map.put("product_category","MOBILE");
        ServiceApi productService = ServiceGenerator.createService(ServiceApi.class);
        Call<ArrayList<Product>> call = productService.GetProductList(map);
        call.enqueue(new Callback<ArrayList<Product>>() {
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                products = response.body();
                mutableLiveData.setValue(products);
            }

            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {
                Log.w("GetProduct", "Failed");
            }

        });

        return mutableLiveData;
    }
}
