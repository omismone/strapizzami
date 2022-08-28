package com.omismone.strapizzami.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;

public class PresentationController {
	private static PresentationController singleton;
	
	private PresentationController() {
		
	}
	
	public static PresentationController getInstance() {
		if(singleton == null) singleton = new PresentationController();
		return singleton;
	}
	
	/**
	 * 
	 * @param request the page needed
	 * @return
	 */
	public String getPage(String request) {
		String response = "";
		

        InputStream input = this.getClass().getResourceAsStream("html/" + request + ".html");

		try {
			BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
            String line;
            while ((line = buffer.readLine()) != null) {
                response += line;
            }
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}
}
