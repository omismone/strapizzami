package com.omismone.strapizzami.model;

public class Drink {
    private String name;
    private String format;
    private int quantity;
    private float price;

    public Drink(String name, String format, int quantity, float price) {
        this.name = name == null ? null : name.toLowerCase();
        this.format = format == null ? null : format.toLowerCase();
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name == null ? null : name.toLowerCase();
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format == null ? null : format.toLowerCase();
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
        return (compare(this.name,other.getName()) && compare(this.format,other.getFormat()) && compare(this.quantity,other.getQuantity()) && compare(this.price,other.getPrice()));
	}
	
	/**
	 * @return true if o1.equals(o2) is true OR both are null.
	 */
	private boolean compare(Object o1, Object o2) {
		return ((o1 == null && o2 == null) || o1.equals(o2));
	}
}
