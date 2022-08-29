package com.omismone.strapizzami.services;

import com.omismone.strapizzami.model.Dish;
import com.omismone.strapizzami.model.Format;
import com.omismone.strapizzami.model.Ingredient;
import com.omismone.strapizzami.model.Classe;
import com.omismone.strapizzami.model.Pizza;
import com.omismone.strapizzami.model.Drink;
import com.omismone.strapizzami.services.dao.*;

import java.util.ArrayList;

public class PersistenceFacade {
    private static PersistenceFacade singleton;
    private PersistenceFactory factory;
    private IClasseDao classe_dao;
    private IFormatDao format_dao;
    private IIngredientDao ingredient_dao;
    private IDrinkDao drink_dao;
    private IDishDao dish_dao;
    private IPizzaDao pizza_dao;
    private PersistenceFacade(){
        factory = PersistenceFactory.getInstance();

        classe_dao = factory.getClasseDao();
        format_dao = factory.getFormatDao();
        ingredient_dao = factory.getIngredientDao();
        drink_dao = factory.getDrinkDao();
        dish_dao = factory.getDishDao();
        pizza_dao = factory.getPizzaDao();
    }

    public static PersistenceFacade getInstance(){
        if(singleton == null) singleton = new PersistenceFacade();
        return singleton;
    }

    public ArrayList<Classe> getClassi(){
        return classe_dao.getClassi();
    }

    public ArrayList<Format> getFormats(){
        return format_dao.getFormats();
    }

    public ArrayList<Drink> getDrinks(){
        return drink_dao.getDrinks();
    }
    
    public ArrayList<Drink> getDrinksByPrice(float price){
    	return drink_dao.getDrinksByPrice(price);
    }

    public ArrayList<Drink> getDrinksByFormat(String format){
    	return drink_dao.getDrinksByFormat(format);
    }

    public ArrayList<Dish> getDishes(){
        return dish_dao.getDishes();
    }
    
    public ArrayList<Dish> getDishesByClasse(Classe classe){
    	return dish_dao.getDishesByClasse(classe);
    }

    public ArrayList<Ingredient> getIngredients(){
        return ingredient_dao.getIngredients();
    }

    public ArrayList<Pizza> getPizzas(){
        return pizza_dao.getPizzas();
    }

    public ArrayList<Pizza> getPizzasByClasse(Classe classe){
    	return pizza_dao.getPizzasByClasse(classe);
    }
    
    public ArrayList<Pizza> getPizzaByName(String name){
    	return pizza_dao.getPizzaByName(name);
    }
    
}
