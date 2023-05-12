package org.example;

public class Product {
    private final int code;
    private final String name;
    private final float unitPrice;

    public Product(int code, String name, float unitPrice) {
        this.code = code;
        this.name = name;
        this.unitPrice = unitPrice;
    }
    //  Return the code of the product
    public int getCode() {
        return code;
    }
    //  Return the name of the product
    public String getName() {
        return name;
    }
    //  Return the unit price of the product
    public float getUnitPrice() {
        return unitPrice;
    }
}