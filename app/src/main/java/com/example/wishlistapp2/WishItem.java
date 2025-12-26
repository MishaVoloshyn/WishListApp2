package com.example.wishlistapp2;

public class WishItem {
    public int imageRes;
    public String name;
    public int price;
    public boolean checked;

    public WishItem(int imageRes, String name, int price) {
        this.imageRes = imageRes;
        this.name = name;
        this.price = price;
        this.checked = false;
    }
}
