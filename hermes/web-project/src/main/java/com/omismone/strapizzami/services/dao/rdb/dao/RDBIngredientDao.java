package com.omismone.strapizzami.services.dao.rdb.dao;

import com.omismone.strapizzami.model.Ingredient;
import com.omismone.strapizzami.services.dao.IIngredientDao;
import com.omismone.strapizzami.services.dao.rdb.RDBOperator;

import java.sql.Connection;
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
        if(cache != null) return cache;
        try{
            Connection c = operator.startConnection();
            cache = map(operator.getIngredients(c));
            operator.closeConnection(c);
            return cache;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ArrayList<Ingredient> map(ResultSet rs){
        ArrayList<Ingredient> result = new ArrayList<Ingredient>();
        try{
            while(rs.next()){
                String name = rs.getString("NOME");
                Boolean frozen = (Boolean) rs.getObject("SURGELATO");
                Float price = rs.getFloat("PREZZO");

                result.add(new Ingredient(name, frozen, price));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}