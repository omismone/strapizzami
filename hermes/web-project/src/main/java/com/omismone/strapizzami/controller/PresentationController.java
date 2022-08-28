package com.omismone.strapizzami.controller;


public class PresentationController {
	private static PresentationController singleton;
	
	private PresentationController() {
		
	}
	
	public static PresentationController getInstance() {
		if(singleton == null) singleton = new PresentationController();
		return singleton;
	}
	
	/**
	 * @return menu html
	 */
	public String getMenu() {
		String content = "";
		
		return content;
	}
}
