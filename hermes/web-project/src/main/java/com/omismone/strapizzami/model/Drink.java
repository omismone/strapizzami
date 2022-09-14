package com.omismone.strapizzami.model;

public class Drink {
    private String name;
    private String format;
    private int quantity;
    private float price;

    public Drink(String name, String format, int quantity, float price) {
        this.name = name;
        this.format = format;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
	@Override
	public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Drink other = (Drink) obj;
        return (other.getName().equals(this.name) && other.getFormat().equals(this.format) && other.getQuantity() == this.quantity && other.getPrice() == this.price);
	}
}
