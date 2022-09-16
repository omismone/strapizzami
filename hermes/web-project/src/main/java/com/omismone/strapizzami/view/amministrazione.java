package com.omismone.strapizzami.view;

import java.io.IOException;
import java.io.PrintWriter;

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
	    String[] ingredients=request.getParameterValues("ingredients");
	    
	    //want to insert a new pizza
	    if(name != null && price != null && ingredients != null && ingredients.length != 0) {
	    	contr.insertWeeklyPizza(name, Float.parseFloat(price), ingredients);
	    	out.print("<html><head></head><body>inserita</body></html>");
	    	out.close();
	    	return;
	    }

	    out.print(contr.getAdminPage());
	    
	    out.close();   
		
	}

}
