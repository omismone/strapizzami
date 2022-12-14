package com.omismone.strapizzami.services.dao.rdb.dao;

import com.omismone.strapizzami.model.Classe;
import com.omismone.strapizzami.services.dao.IClasseDao;
import com.omismone.strapizzami.services.dao.rdb.RDBOperator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RDBClasseDao implements IClasseDao {
    private RDBOperator operator;
    private ArrayList<Classe> cache;

    public RDBClasseDao(){
        operator = RDBOperator.getInstance();
    }

    /**
     * in the ArrayList returned by this function Classi will be sorted by the attribute 'relevance'
     * more relevance -> before in the array
     * @return
     */
    @Override
    public ArrayList<Classe> getClassi() {
        if(cache != null) return cache;
        try{
            Connection c = operator.startConnection();
            cache = map(operator.getClassi(c));
            operator.closeConnection(c);
            return cache;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ArrayList<Classe> map(ResultSet rs){
        ArrayList<Classe> result = new ArrayList<Classe>();
        try {
            while(rs.next()) {
                String name = rs.getString("NOME");
                String descr = rs.getString("DESCRIZIONE");
                int relevance = rs.getInt("IMPORTANZA");
                result.add(new Classe(name,descr,relevance));
            }
            
            //sorting by relevance attr
            Collections.sort(result, Comparator.comparing(Classe::getRelevance));

            return result;
        } catch (SQLException e) {
            return null;
        }

    }

    /**
     * @return true if the supplied input is now present (if it already existed also true)
     */
	@Override
	public Boolean insertClasse(Classe classe) {
		if(cache == null) getClassi();
		if(cache.contains(classe)) return true;
		Boolean result = false;
        try{
            Connection c = operator.startConnection();
            result = operator.insertClasse(c, classe.getName(), classe.getDescription(), classe.getRelevance().intValue());
            operator.closeConnection(c);
            return result;
        } catch (SQLException e) {
            return false;
        }
	}
}
