package services.dao.rdb.dao;

import model.Ingredient;
import services.dao.IIngredientDao;
import services.dao.rdb.RDBOperator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RDBIngredientDao implements IIngredientDao {
    private RDBOperator operator;
    private ArrayList<Ingredient> cache;

    public RDBIngredientDao(){
        operator = RDBOperator.getInstance();
    }
    @Override
    public ArrayList<Ingredient> getIngredients() {
        if(cache == null) cache = map(operator.getIngredients());
        return cache;
    }

    private ArrayList<Ingredient> map(ResultSet rs){
        ArrayList<Ingredient> result = new ArrayList<Ingredient>();
        try{
            while(rs.next()){
                String name = rs.getString("NAME");
                Boolean frozen = rs.getBoolean("SURGELATO");
                Float price = rs.getBigDecimal("PREZZO").floatValue();

                result.add(new Ingredient(name, frozen, price));
            }
            return result;
        }catch (SQLException ex){return null;}
    }
}
