package services.dao.rdb;


import java.sql.ResultSet;

public class RDBOperator {
    private static RDBOperator singleton;

    private RDBOperator(){

    }

    public static RDBOperator getInstance(){
        if(singleton == null) singleton = new RDBOperator();
        return singleton;
    }

    public ResultSet getPizzas(){
        return null;
    }

    public ResultSet getDishes(){
        return null;
    }

    public ResultSet getDrinks(){
        return null;
    }

    public ResultSet getClassi(){
        return null;
    }

    public ResultSet getFormats(){
        return null;
    }

    public ResultSet getIngredients(){
        return null;
    }

    public ResultSet getPFS(){
        return null;
    }

    public ResultSet getPIS(){
        return null;
    }

    public ResultSet getIPS(){
        return null;
    }
}
