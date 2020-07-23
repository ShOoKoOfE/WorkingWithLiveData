package com.shokoofeadeli.workingwithlivedata;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private ProductRepository productRepository;
    public MainViewModel(@NonNull Application application) {
        super(application);
        productRepository = new ProductRepository(application);
    }
    public LiveData<ArrayList<Product>> getAllProduct() {
        return productRepository.getMutableLiveData();
    }
}