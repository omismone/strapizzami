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
        return (other.getName().equals(this.name) && other.getClasse().equals(this.classe) && this.format.equals(other.getFormat()) && this.price == other.getPrice() && this.visible.equals(other.getVisible()) && this.ingredients.size() == other.getIngredients().size() && this.ingredients.containsAll(other.getIngredients()));
	}

}
