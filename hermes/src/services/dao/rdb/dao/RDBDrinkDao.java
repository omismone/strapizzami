package services.dao.rdb.dao;

import model.Drink;
import services.dao.IDrinkDao;
import services.dao.rdb.RDBOperator;

import java.sql.ResultSet;
import java.util.ArrayList;

public class RDBDrinkDao implements IDrinkDao {
    private RDBOperator operator;

    public RDBDrinkDao(){
        operator = RDBOperator.getInstance();
    }
    @Override
    public ArrayList<Drink> getDrinks() {
        return map(operator.getDrinks());
    }

    private ArrayList<Drink> map(ResultSet rs){
        return null;
    }
}
