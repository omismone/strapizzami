package services.dao.rdb.dao;

import model.Classe;
import services.dao.IClasseDao;
import services.dao.rdb.RDBOperator;

import java.sql.ResultSet;
import java.util.ArrayList;

public class RDBClasseDao implements IClasseDao {
    private RDBOperator operator;

    public RDBClasseDao(){
        operator = RDBOperator.getInstance();
    }
    @Override
    public ArrayList<Classe> getClassi() {
        return map(operator.getClassi());
    }

    private ArrayList<Classe> map(ResultSet rs){
        return null;
    }
}
