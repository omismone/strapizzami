package model;

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
}
