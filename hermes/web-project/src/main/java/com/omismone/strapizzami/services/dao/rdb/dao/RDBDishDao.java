package com.omismone.strapizzami.services.dao.rdb.dao;

import com.omismone.strapizzami.model.Dish;
import com.omismone.strapizzami.model.Ingredient;
import com.omismone.strapizzami.services.PersistenceFacade;
import com.omismone.strapizzami.services.dao.IDishDao;
import com.omismone.strapizzami.services.dao.rdb.RDBOperator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RDBDishDao implements IDishDao {
    private RDBOperator operator;
    private ArrayList<Dish> cache;

    public RDBDishDao(){
        operator = RDBOperator.getInstance();
    }
    @Override
    public ArrayList<Dish> getDishes() {
        if(cache != null) return cache;
        try{
            Connection c1, c2;
            c1 = operator.startConnection();
            c2 = operator.startConnection();
            cache = map(operator.getDishes(c1), operator.getIPS(c2));
            operator.closeConnection(c1);
            operator.closeConnection(c2);
            return cache;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * this method is highly coupled with the design of dishes on e/r com.omismone.strapizzami.model
     * see that to know why it's implemented like this
     *
     * this method calls PersistenceFacade to get the ingredients list and classes list
     */
    private ArrayList<Dish> map(ResultSet dishes, ResultSet ips){
        try{
            ArrayList<Dish> result = new ArrayList<Dish>();
            while(dishes.next()){
                Dish current_dish;
                String name = dishes.getString("NOME");
                Boolean frozen = (Boolean) dishes.getObject("SURGELATO");

                Float price = dishes.getFloat("PREZZO");
                current_dish = new Dish(name,null,frozen,price,null);

                //get from persistence facade all classes and add the right one to the current dish
                String classe_name = dishes.getString("CLASSE");
                PersistenceFacade.getInstance().getClassi().forEach(clazz -> {if(clazz.getName().equals(classe_name)) current_dish.setClasse(clazz);});

                result.add(current_dish);
            }
            ArrayList<Ingredient> tot_ingredients = PersistenceFacade.getInstance().getIngredients();
            while(ips.next()){
                String dish_name = ips.getString("PIETANZA");
                String ingredient_name = ips.getString("INGREDIENTE");

                //insert in the right dish the ingredient that is in the ip
                result.forEach(dish -> { if(dish.getName().equals(dish_name)) tot_ingredients.forEach(ingredient -> {if(ingredient.getName().equals(ingredient_name)) dish.addIngredient(ingredient);}); });
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
