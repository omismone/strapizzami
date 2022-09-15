package com.omismone.strapizzami.model;

import java.util.ArrayList;

public class Dish {
    private String name;
    private Classe classe;
    private Boolean frozen;
    private float price;
    private ArrayList<Ingredient> ingredients;

    public Dish(String name, Classe classe, Boolean frozen, float price, ArrayList<Ingredient> ingredients) {
        this.name = name;
        this.classe = classe;
        this.frozen = frozen;
        this.price = price;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
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
    
	@Override
	public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Dish other = (Dish) obj;
        return (compare(other.getName(),this.name) && compare(other.getClasse(),this.classe) && compare(other.getFrozen(),this.frozen) && compare(other.getPrice(),this.price) && ((this.ingredients == null && other.getIngredients() == null) || this.ingredients.size() == other.getIngredients().size() && other.getIngredients().containsAll(this.ingredients)));
	}
	
	/**
	 * @return true if o1.equals(o2) is true OR both are null.
	 */
	private boolean compare(Object o1, Object o2) {
		return ((o1 == null && o2 == null) || o1.equals(o2));
	}
}
