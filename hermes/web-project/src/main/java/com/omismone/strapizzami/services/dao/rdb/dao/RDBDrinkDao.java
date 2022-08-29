package com.omismone.strapizzami.services.dao.rdb.dao;

import com.omismone.strapizzami.model.Drink;
import com.omismone.strapizzami.services.dao.IDrinkDao;
import com.omismone.strapizzami.services.dao.rdb.RDBOperator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RDBDrinkDao implements IDrinkDao {
    private RDBOperator operator;
    private ArrayList<Drink> cache;

    public RDBDrinkDao(){
        operator = RDBOperator.getInstance();
    }
    @Override
    public ArrayList<Drink> getDrinks() {
        if(cache != null) return cache;
        try{
            Connection c = operator.startConnection();
            cache = map(operator.getDrinks(c));
            operator.closeConnection(c);
            return cache;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

	@Override
	public ArrayList<Drink> getDrinksByPrice(float price) {
		if(cache == null) getDrinks();
		ArrayList<Drink> byprice = new ArrayList<Drink>();
		cache.forEach(drink -> {if(drink.getPrice() == price) byprice.add(drink);});
		return byprice;
	}
	

	@Override
	public ArrayList<Drink> getDrinksByFormat(String format) {
		if(cache == null) getDrinks();
		ArrayList<Drink> byformat = new ArrayList<Drink>();
		cache.forEach(drink -> {if(drink.getFormat().equals(format)) byformat.add(drink);});
		return byformat;
	}

    private ArrayList<Drink> map(ResultSet rs){
        ArrayList<Drink> result = new ArrayList<Drink>();
        try{
            while(rs.next()){
                String name = rs.getString("NOME");
                int quantity = rs.getInt("QUANTITA");
                Float price = rs.getFloat("PREZZO");

                //idk if sql enum can be get by java Strings:
                String drink_format = rs.getString("FORMATO");

                result.add(new Drink(name,drink_format,quantity,price));
            }
            return result;
        }catch(SQLException ex){return null;}
    }
}
