package com.omismone.strapizzami.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import com.omismone.strapizzami.controller.AdminController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class amministrazione
 */
@WebServlet("/amministrazione")
public class amministrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
    	out.print("<html><head>");
    	out.print("<meta http-equiv=\"refresh\" content=\"0;URL=/login\"></head><body></body></html>");
    	out.close();	
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   	response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    
	    //get credenziali
	    String user=request.getParameter("username");  
	    String pass=request.getParameter("password");  
	    
	    AdminController contr = AdminController.getInstance();
	    
	    //credenziali errate
	    if(!contr.login(user, pass)){
	    	out.print("<html><head>");
	    	out.println("<script type=\"text/javascript\">alert('credenziali errate');</script>");
	    	out.print("<meta http-equiv=\"refresh\" content=\"0;URL=/login\"></head><body></body></html>");
	    	out.close();
	    	return;
	    }
	    
	    //credenziali corrette
	    String name=request.getParameter("name");  
	    String price=request.getParameter("price");
	    String[] ingredients_name=request.getParameterValues("ingredientsName");
	    
	    //want to insert a new pizza
	    if(name != null && price != null && ingredients_name != null && ingredients_name.length != 0) {
	    	
	    	//come richiesto da specifiche: gli ingredienti non saranno presentati nel menù
	    	String[] ingredients_price = new String[ingredients_name.length];
	    	Arrays.fill(ingredients_price, "1000");
	    	Boolean[] ingredients_frozen = new Boolean[ingredients_name.length];
	    	Arrays.fill(ingredients_frozen, false);
	    	
	    	if(contr.insertWeeklyPizza(name, Float.parseFloat(price), ingredients_name, ingredients_price, ingredients_frozen))
	    	{
		    	out.print("<html><head>");
		    	out.println("<script type=\"text/javascript\">alert('Inserimento avvenuto!\\nPotrebbe essere necessaria qualche ora prima che la modifica sia applicata ovunque.');</script>");
		    	out.print("<meta http-equiv=\"refresh\" content=\"0;URL=/home\"></head><body></body></html>");
	    	}
	    	else {
		    	out.print("<html><head>");
		    	out.println("<script type=\"text/javascript\">alert('Inserimento fallito!\\nVerificare che le informazioni inserite siano valide e riprovare.');</script>");
		    	out.print("<meta http-equiv=\"refresh\" content=\"0;URL=/login\"></head><body></body></html>");
	    	}
	    	out.close();
	    	return;
	    }

	    out.print(contr.getAdminPage());
	    
	    out.close();   
		
	}

}
