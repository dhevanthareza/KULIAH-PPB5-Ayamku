package com.kuliahdhevan.ayamku;

public class Food {
    private String name;
    private int price;
    private final int imageResource;

    Food(String name, int price, int imageResource){
        this.name =name;
        this.price = price;
        this.imageResource = imageResource;
    }

    String getName() { return name; }
    int getPrice() { return price; }
    int getImageResource() { return imageResource; }
}
