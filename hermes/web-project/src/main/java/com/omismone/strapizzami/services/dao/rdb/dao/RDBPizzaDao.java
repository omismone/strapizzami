package com.omismone.strapizzami.services.dao.rdb.dao;

import com.omismone.strapizzami.model.Classe;
import com.omismone.strapizzami.model.Format;
import com.omismone.strapizzami.model.Ingredient;
import com.omismone.strapizzami.model.Pizza;
import com.omismone.strapizzami.services.PersistenceFacade;
import com.omismone.strapizzami.services.dao.IPizzaDao;
import com.omismone.strapizzami.services.dao.rdb.RDBOperator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RDBPizzaDao implements IPizzaDao {
    private RDBOperator operator;
    private ArrayList<Pizza> cache;

    public RDBPizzaDao(){
        operator = RDBOperator.getInstance();
    }
    @Override
    public ArrayList<Pizza> getPizzas() {
        if(cache != null) return cache;
        try{
            Connection c1 = operator.startConnection();
            Connection c2 = operator.startConnection();
            Connection c3 = operator.startConnection();
            cache = map(operator.getPizzas(c1), operator.getPIS(c2), operator.getPFS(c3));
            operator.closeConnection(c1);
            operator.closeConnection(c2);
            operator.closeConnection(c3);
            return cache;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

	@Override
	public ArrayList<Pizza> getPizzasByClasse(Classe classe) {
		if(cache == null) getPizzas();
		ArrayList<Pizza> byclasse = new ArrayList<Pizza>();
		cache.forEach(pizza -> {if(pizza.getClasse().equals(classe)) byclasse.add(pizza);});
		return byclasse;
	}

	@Override
	public ArrayList<Pizza> getPizzasByName(String name) {
		if(cache == null) getPizzas();
		ArrayList<Pizza> byname = new ArrayList<Pizza>();
		cache.forEach(pizza -> {if(pizza.getName().equals(name)) byname.add(pizza);});
		return byname;
	}
	
    /**
     * this method is highly coupled with the design of pizzas on e/r com.omismone.strapizzami.model
     * see that to know why it's implemented like this
     *
     * this method calls PersistenceFacade to get the ingredients, classes and formats list
     */
    private ArrayList<Pizza> map(ResultSet pizzas, ResultSet pis, ResultSet pfs){
        ArrayList<Pizza> result = new ArrayList<Pizza>();
        //partial result contains all pizzas skeleton(without format and price that are on pfs), result duplicate those pizzas for each pizza's format in pfs
        ArrayList<Pizza> partial_result = new ArrayList<Pizza>();
        try{
            while(pizzas.next()){
                Pizza current_pizza = new Pizza(pizzas.getString("NOME"),null,null,0, null);

                //get from persistence facade all classes and add the right one to the current dish
                String classe_name = pizzas.getString("CLASSE");
                PersistenceFacade.getInstance().getClassi().forEach(clazz -> {if(clazz.getName().equals(classe_name)) current_pizza.setClasse(clazz);});

                partial_result.add(current_pizza);
            }
            //get from persistence facade all ingredients
            ArrayList<Ingredient> tot_ingredients = PersistenceFacade.getInstance().getIngredients();
            while(pis.next()){
                String pizza_name = pis.getString("PIZZA");
                String ingredient_name = pis.getString("INGREDIENTE");

                //insert in the right pizza the ingredient that is in the pi
                partial_result.forEach(pizza -> { if(pizza.getName().equals(pizza_name)) tot_ingredients.forEach(ingredient -> {if(ingredient.getName().equals(ingredient_name)) pizza.addIngredient(ingredient);}); });
            }
            //get from persistence facade all formats
            ArrayList<Format> tot_formats = PersistenceFacade.getInstance().getFormats();
            while(pfs.next()){
                String pizza_name = pfs.getString("PIZZA");
                String format_name = pfs.getString("FORMATO");
                float price = pfs.getBigDecimal("PREZZO").floatValue();

                //insert in result the pizza, getting info from partial result and pfs
                partial_result.forEach(pizza -> { if(pizza.getName().equals(pizza_name)) tot_formats.forEach(format -> {if(format.getName().equals(format_name)) result.add(new Pizza(pizza.getName(), format, pizza.getClasse(), price, pizza.getIngredients()));}); });
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
	@Override
	public Boolean insertPizza(Pizza pizza) {
		
		return null;
	}
}
