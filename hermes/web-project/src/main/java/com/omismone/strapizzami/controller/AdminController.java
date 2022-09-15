package com.omismone.strapizzami.controller;

import com.omismone.strapizzami.controller.utils.IPassChiper;
import com.omismone.strapizzami.controller.utils.PassChiper;
import com.omismone.strapizzami.services.PersistenceFacade; 					//comment this line
// import com.omismone.strapizzami.controller.utils.PassChiperSample; 			//decomment this line

public class AdminController {
	private static AdminController singleton;
	
	private IPassChiper pc;
	private PersistenceFacade pf;
	
	private AdminController() {
		pc = PassChiper.getInstance(); 						//comment this line
		// pc = new PassChiperSample(); 					//decomment this line
		
		pf = PersistenceFacade.getInstance();
		
	}
	
	public static AdminController getInstance() {
		if(singleton == null) singleton = new AdminController();
		return singleton;
	}
	
	public Boolean login(String user, String pass) {
		if(pf.getAdminByNameAndPassword(user, pc.encrypt(pass)) != null) return true;
		return false;
	}
	
	public Boolean insertWeeklyPizza(String pizza_name, float price, String[] ingredients_name) {
		return false;
	}
	
	public String getOldPizzas() {
		return "";
	}
}
