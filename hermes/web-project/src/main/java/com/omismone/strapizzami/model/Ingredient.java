package com.omismone.strapizzami.model;

public class Ingredient {
    private String name;
    private Boolean frozen;
    private Float price;

    public Ingredient(String name, Boolean frozen, Float price){
        this.name = name == null ? null : name.toLowerCase();
        this.frozen = frozen;
        this.price = price;
    }

    public String getName(){
        return name;
    }
    public void setName(String new_name){
        name = new_name == null ? null : new_name.toLowerCase();
    }

    public Boolean getFrozen(){
        return frozen;
    }
    public void setFrozen(Boolean new_frozen){
        frozen = new_frozen;
    }

    public Float getPrice(){
        return price;
    }
    public void setPrice(Float new_price){
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
        return (compare(this.name,other.getName()) && compare(this.frozen,other.getFrozen()) && compare(this.price,other.getPrice()));
	}
	
	/**
	 * @return true if o1.equals(o2) is true OR both are null.
	 */
	private boolean compare(Object o1, Object o2) {
		return ((o1 == null && o2 == null) || o1.equals(o2));
	}
}
