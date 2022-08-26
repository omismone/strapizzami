package services.dao.rdb.dao;

import model.Format;
import model.Ingredient;
import model.Pizza;
import services.PersistenceFacade;
import services.dao.IPizzaDao;
import services.dao.rdb.RDBOperator;

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
        if(cache == null) cache = map(operator.getPizzas(), operator.getPIS(), operator.getPFS());
        return cache;
    }

    /**
     * this method is highly coupled with the design of pizzas on e/r model
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
        }catch (SQLException ex){return null;}
    }
}
