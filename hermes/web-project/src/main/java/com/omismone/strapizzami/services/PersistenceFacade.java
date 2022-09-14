package com.omismone.strapizzami.services;

import com.omismone.strapizzami.model.Dish;
import com.omismone.strapizzami.model.Format;
import com.omismone.strapizzami.model.Ingredient;
import com.omismone.strapizzami.model.Admin;
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
    private IAdminDao admin_dao;
    
    private PersistenceFacade(){
        factory = PersistenceFactory.getInstance();

        classe_dao = factory.getClasseDao();
        format_dao = factory.getFormatDao();
        ingredient_dao = factory.getIngredientDao();
        drink_dao = factory.getDrinkDao();
        dish_dao = factory.getDishDao();
        pizza_dao = factory.getPizzaDao();
        admin_dao = factory.getAdminDao();
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
    
    public ArrayList<Pizza> getPizzasByName(String name){
    	return pizza_dao.getPizzasByName(name);
    }
    
    public ArrayList<Admin> getAdmins(){
    	return admin_dao.getAdmins();
    }
    
	public Admin getAdminByNameAndPassword(String name, String pass) {
		return admin_dao.getAdminByNameAndPassword(name, pass);
	}
	
	public Boolean insertPizza(Pizza pizza) {
		return pizza_dao.insertPizza(pizza);
	}
	public Boolean insertIngredient(Ingredient ingredient) {
		return ingredient_dao.insertIngredient(ingredient);
	}
	public Boolean insertClasse(Classe classe) {
		return classe_dao.insertClasse(classe);
	}
	public Boolean insertFormat(Format format) {
		return format_dao.insertFormat(format);
	}
}
