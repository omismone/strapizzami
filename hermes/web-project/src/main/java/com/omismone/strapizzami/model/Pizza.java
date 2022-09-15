package com.omismone.strapizzami.model;

import java.util.ArrayList;

public class Pizza {
    private String name;
    private Format format;
    private Classe classe;
    private float price;
    private ArrayList<Ingredient> ingredients;
    private Boolean visible;

    public Pizza(String name, Format format, Classe classe, float price, ArrayList<Ingredient> ingredients, Boolean visibility) {
        this.name = name;
        this.format = format;
        this.classe = classe;
        this.price = price;
        this.ingredients = ingredients;
        this.setVisible(visibility);
    }
    /**
     * visibility default: true
     */
    public Pizza(String name, Format format, Classe classe, float price, ArrayList<Ingredient> ingredients) {
        this(name,format,classe,price,ingredients,true);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient ingredient){
        if(this.ingredients == null) this.ingredients = new ArrayList<Ingredient>();
        this.ingredients.add(ingredient);
    }
    
	public Boolean getVisible() {
		return visible;
	}
	
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	@Override
	public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Pizza other = (Pizza) obj;
        return (compare(other.getName(),this.name) && compare(other.getClasse(),this.classe) && compare(other.getFormat(),this.format) && compare(other.getPrice(),this.price) && compare(other.getVisible(),this.visible) && ((this.ingredients == null && other.getIngredients() == null) || this.ingredients.size() == other.getIngredients().size() && other.getIngredients().containsAll(this.ingredients)));
	}

	/**
	 * @return true if o1.equals(o2) is true OR both are null.
	 */
	private boolean compare(Object o1, Object o2) {
		return ((o1 == null && o2 == null) || o1.equals(o2));
	}
}
