package com.omismone.strapizzami.services.dao;

import java.util.ArrayList;

import com.omismone.strapizzami.model.Admin;

public interface IAdminDao {
	public ArrayList<Admin> getAdmins();
	public ArrayList<Admin> getAdminsByName(String name);
}
