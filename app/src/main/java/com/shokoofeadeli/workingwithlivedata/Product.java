package com.shokoofeadeli.workingwithlivedata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@SuppressWarnings("unused")
public class Product {
  @SerializedName("product_id")
  @Expose
  private int product_id;
  @SerializedName("product_code")
  @Expose
  private String product_code;
  @SerializedName("product_name")
  @Expose
  private String product_name;
  @SerializedName("product_price")
  @Expose
  private long product_price;
  @SerializedName("product_imageUrl")
  @Expose
  private String product_imageUrl;
  @SerializedName("product_factory")
  @Expose
  private String product_factory;
  @SerializedName("product_rate")
  @Expose
  private float product_rate;
  @SerializedName("product_count")
  @Expose
  private int product_count;
  @SerializedName("basket_product_count")
  @Expose
  private int basket_product_count;

  public int getProduct_id() {
    return product_id;
  }

  public void setProduct_id(int product_id) {
    this.product_id = product_id;
  }

  public String getProduct_code() {
    return product_code;
  }

  public void setProduct_code(String product_code) {
    this.product_code = product_code;
  }

  public String getProduct_name() {
    return product_name;
  }

  public void setProduct_name(String product_name) {
    this.product_name = product_name;
  }

  public long getProduct_price() {
    return product_price;
  }

  public void setProduct_price(long product_price) {
    this.product_price = product_price;
  }

  public String getProduct_imageUrl() {
    return product_imageUrl;
  }

  public void setProduct_imageUrl(String product_imageUrl) {
    this.product_imageUrl = product_imageUrl;
  }

  public String getProduct_factory() {
    return product_factory;
  }

  public void setProduct_factory(String product_factory) {
    this.product_factory = product_factory;
  }

  public float getProduct_rate() {
    return product_rate;
  }

  public void setProduct_rate(float product_rate) {
    this.product_rate = product_rate;
  }

  public int getProduct_count() {
    return product_count;
  }

  public void setProduct_count(int product_count) {
    this.product_count = product_count;
  }

  public int getBasket_product_count() {
    return basket_product_count;
  }

  public void setBasket_product_count(int basket_product_count) {
    this.basket_product_count = basket_product_count;
  }
}
