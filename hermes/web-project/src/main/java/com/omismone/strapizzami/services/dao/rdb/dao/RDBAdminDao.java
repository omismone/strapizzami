package com.omismone.strapizzami.services.dao.rdb.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.omismone.strapizzami.model.Admin;
import com.omismone.strapizzami.services.dao.IAdminDao;
import com.omismone.strapizzami.services.dao.rdb.RDBOperator;

public class RDBAdminDao implements IAdminDao{
	private ArrayList<Admin> cache;
	private RDBOperator operator;
	
	public RDBAdminDao() {
		operator = RDBOperator.getInstance();
	}
	
	@Override
	public ArrayList<Admin> getAdmins() {
        if(cache != null) return cache;
        try{
            Connection c = operator.startConnection();
            cache = map(operator.getAdmins(c));
            operator.closeConnection(c);
            return cache;
        } catch (SQLException e) { return null; }
	}

	@Override
	public ArrayList<Admin> getAdminsByName(String name) {
		if(cache == null) getAdmins();
		ArrayList<Admin> byname = new ArrayList<Admin>();
		cache.forEach(admin -> {if(admin.getName().equals(name)) byname.add(admin);});
		return byname;
	}
	
	private ArrayList<Admin> map(ResultSet rs){
		ArrayList<Admin> result = new ArrayList<Admin>();
        try{
            while(rs.next()){
                String name = rs.getString("NOME");
                String pass = rs.getString("PASSWORD");

                result.add(new Admin(name,pass));
            }
            return result;
        }catch(SQLException ex){return null;}
	}

}
