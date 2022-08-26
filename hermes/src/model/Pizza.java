package model;

import java.util.ArrayList;

public class Pizza {
    private String name;
    private Format format;
    private Classe classe;
    private float price;
    private ArrayList<Ingredient> ingredients;

    public Pizza(String name, Format format, Classe classe, float price, ArrayList<Ingredient> ingredients) {
        this.name = name;
        this.format = format;
        this.classe = classe;
        this.price = price;
        this.ingredients = ingredients;
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

}
