package com.shokoofeadeli.workingwithlivedata;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    SwipeRefreshLayout swipeRefresh;
    ProductRecyclerAdapter productRecyclerAdapter;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeRefresh = findViewById(R.id.swiperefresh);
        mRecyclerView = findViewById(R.id.recyclerView);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        getProduct();
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getProduct();
            }
        });
    }

    private void getProduct() {
        swipeRefresh.setRefreshing(true);
        mainViewModel.getAllProduct().observe(this, new Observer<ArrayList<Product>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Product> productList) {
                swipeRefresh.setRefreshing(false);
                prepareRecyclerView(productList);
            }
        });
    }

    private void prepareRecyclerView(ArrayList<Product> productList) {
        productRecyclerAdapter = new ProductRecyclerAdapter(this, productList);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        }
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(productRecyclerAdapter);
        productRecyclerAdapter.notifyDataSetChanged();
    }


}