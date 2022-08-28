package com.omismone.strapizzami.controller;

public class PresentationController {
	private static PresentationController singleton;
	
	private PresentationController() {
		
	}
	
	public static PresentationController getInstance() {
		if(singleton == null) singleton = new PresentationController();
		return singleton;
	}
	
	public String getPage(String request) {
		return "<h1>funziona</h1>";
	}
}
