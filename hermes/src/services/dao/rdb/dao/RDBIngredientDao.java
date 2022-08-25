package services.dao.rdb.dao;

import model.Ingredient;
import services.dao.IIngredientDao;
import services.dao.rdb.RDBOperator;

import java.sql.ResultSet;
import java.util.ArrayList;

public class RDBIngredientDao implements IIngredientDao {
    private RDBOperator operator;

    public RDBIngredientDao(){
        operator = RDBOperator.getInstance();
    }
    @Override
    public ArrayList<Ingredient> getIngredients() {
        return map(operator.getIngredients());
    }

    private ArrayList<Ingredient> map(ResultSet rs){
        return null;
    }
}
