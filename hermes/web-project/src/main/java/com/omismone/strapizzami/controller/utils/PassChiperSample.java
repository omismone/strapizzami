package com.omismone.strapizzami.controller.utils;

public class PassChiperSample implements IPassChiper{
	@Override
	public String encrypt(String s) {
		if(s == null) return null;
		// write your encryption method
		return s; //check db max length!!
	}
	
}
