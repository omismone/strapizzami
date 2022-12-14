package com.omismone.strapizzami.services.dao.rdb.dao;

import com.omismone.strapizzami.model.Format;
import com.omismone.strapizzami.services.dao.IFormatDao;
import com.omismone.strapizzami.services.dao.rdb.RDBOperator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RDBFormatDao implements IFormatDao {
    private RDBOperator operator;
    private ArrayList<Format> cache;

    public RDBFormatDao(){
        operator = RDBOperator.getInstance();
    }
    @Override
    public ArrayList<Format> getFormats() {
        if(cache != null) return cache;
        try{
            Connection c = operator.startConnection();
            cache = map(operator.getFormats(c));
            operator.closeConnection(c);
            return cache;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ArrayList<Format> map(ResultSet rs){
        ArrayList<Format> result = new ArrayList<Format>();
        try{
            while(rs.next()){
                result.add(new Format(rs.getString("NOME")));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * @return true if the supplied input is now present (if it already existed also true)
     */
	@Override
	public Boolean insertFormat(Format format) {
		if(cache == null) getFormats();
		if(cache.contains(format)) return true;
		Boolean result = false;
        try{
            Connection c = operator.startConnection();
            result = operator.insertFormat(c, format.getName());
            operator.closeConnection(c);
            return result;
        } catch (SQLException e) {
            return false;
        }
	}
}
