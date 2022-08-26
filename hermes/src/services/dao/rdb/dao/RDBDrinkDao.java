package services.dao.rdb.dao;

import model.Drink;
import services.dao.IDrinkDao;
import services.dao.rdb.RDBOperator;

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
        if(cache == null) cache = map(operator.getDrinks());
        return cache;
    }

    private ArrayList<Drink> map(ResultSet rs){
        ArrayList<Drink> result = new ArrayList<Drink>();
        try{
            while(rs.next()){
                String name = rs.getString("NOME");
                int quantity = rs.getInt("QUANTITA");
                Float price = rs.getBigDecimal("PREZZO").floatValue();

                //idk if sql enum can be get by java Strings:
                String drink_format = rs.getString("FORMATO");

                result.add(new Drink(name,drink_format,quantity,price));
            }
            return result;
        }catch(SQLException ex){return null;}
    }
}
