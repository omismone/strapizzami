package services.dao.rdb.dao;

import model.Format;
import services.dao.IFormatDao;
import services.dao.rdb.RDBOperator;

import java.sql.ResultSet;
import java.util.ArrayList;

public class RDBFormatDao implements IFormatDao {
    private RDBOperator operator;

    public RDBFormatDao(){
        operator = RDBOperator.getInstance();
    }
    @Override
    public ArrayList<Format> getFormats() {
        return map(operator.getFormats());
    }

    private ArrayList<Format> map(ResultSet rs){
        return null;
    }
}
