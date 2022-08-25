package services.dao.rdb.dao;

import model.Pizza;
import services.dao.IPizzaDao;
import services.dao.rdb.RDBOperator;

import java.sql.ResultSet;
import java.util.ArrayList;

public class RDBPizzaDao implements IPizzaDao {
    private RDBOperator operator;

    public RDBPizzaDao(){
        operator = RDBOperator.getInstance();
    }
    @Override
    public ArrayList<Pizza> getPizzas() {
        return map(operator.getPizzas(), operator.getPIS(), operator.getClassi(), operator.getIngredients(), operator.getFormats());
    }

    /**
     * this method is highly coupled with the design of pizzas on e/r model
     * see that to know why it's implemented like this
     */
    private ArrayList<Pizza> map(ResultSet pizzas, ResultSet pis, ResultSet classi, ResultSet ingredients, ResultSet formats){
        return null;
    }
}
