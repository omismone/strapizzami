package services.dao.rdb.dao;

import model.Dish;
import services.dao.IDishDao;
import services.dao.rdb.RDBOperator;

import java.sql.ResultSet;
import java.util.ArrayList;

public class RDBDishDao implements IDishDao {
    private RDBOperator operator;

    public RDBDishDao(){
        operator = RDBOperator.getInstance();
    }
    @Override
    public ArrayList<Dish> getDishes() {
        return map(operator.getDishes(), operator.getIPS(), operator.getClassi(), operator.getIngredients());
    }

    /**
     * this method is highly coupled with the design of dishes on e/r model
     * see that to know why it's implemented like this
     */
    private ArrayList<Dish> map(ResultSet dishes, ResultSet ips, ResultSet classi, ResultSet ingredients){
        return null;
    }
}
