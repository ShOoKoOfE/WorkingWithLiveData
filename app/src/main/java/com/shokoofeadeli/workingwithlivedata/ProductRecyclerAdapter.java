package com.shokoofeadeli.workingwithlivedata;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.shokoofeadeli.workingwithlivedata.ServiceGenerator.API_BASE_URL;


public class ProductRecyclerAdapter extends RecyclerView.Adapter<ProductRecyclerAdapter.ViewHolder> {

  private ArrayList<Product> productsList;
  private Context context;
  public ProductRecyclerAdapter(Context context, ArrayList<Product> productsList) {
    this.context = context;
    this.productsList = productsList;
  }


  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_product, parent, false);
    return new ViewHolder(view);
  }

  @SuppressLint("SetTextI18n")
  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {

    final Product product = productsList.get(position);
    holder.txtProductName.setText(product.getProduct_name());
    holder.txtProductCode.setText(product.getProduct_code());
    if (product.getProduct_count() == 0) {
      holder.txtProductPrice.setText("" + context.getString(R.string.not_exists));
    } else {
      holder.txtProductPrice.setText("" + product.getProduct_price());
    }

    String imageURL = API_BASE_URL + product.getProduct_imageUrl();
    Picasso.with(context).load(imageURL).into(holder.imgProduct);


  }

  @Override
  public int getItemCount() {
    return productsList.size();
  }

  static class ViewHolder extends RecyclerView.ViewHolder {
    ViewGroup root;
    ImageView imgProduct;
    TextView txtProductName;
    TextView txtProductCode;
    TextView txtProductPrice;

    public ViewHolder(View view) {
      super(view);
      root = (ViewGroup) view;
      imgProduct = view.findViewById(R.id.imgProduct);
      txtProductName = view.findViewById(R.id.txtProductName);
      txtProductCode = view.findViewById(R.id.txtProductCode);
      txtProductPrice = view.findViewById(R.id.txtProductPrice);
    }
  }
}
