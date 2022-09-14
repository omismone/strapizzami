package com.omismone.strapizzami.model;

public class Ingredient {
    private String name;
    private Boolean frozen;
    private float price;

    public Ingredient(String name, Boolean frozen, float price){
        this.name = name;
        this.frozen = frozen;
        this.price = price;
    }

    public String getName(){
        return name;
    }
    public void setName(String new_name){
        name = new_name;
    }

    public Boolean getFrozen(){
        return frozen;
    }
    public void setFrozen(Boolean new_frozen){
        frozen = new_frozen;
    }

    public float getPrice(){
        return price;
    }
    public void setPrice(float new_price){
        price = new_price;
    }

	@Override
	public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Ingredient other = (Ingredient) obj;
        return (other.getName().equals(this.name) && other.getFrozen().equals(this.frozen) && other.getPrice() == this.price);
	}
}
