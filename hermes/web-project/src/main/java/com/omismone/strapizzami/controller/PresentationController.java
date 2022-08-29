package com.omismone.strapizzami.controller;

import java.util.ArrayList;

import com.omismone.strapizzami.model.Classe;
import com.omismone.strapizzami.model.Dish;
import com.omismone.strapizzami.model.Drink;
import com.omismone.strapizzami.model.Pizza;
import com.omismone.strapizzami.services.PersistenceFacade;

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
		String first_half = "<!doctype html><html lang=\"it\"><head><meta charset=\"utf-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><title id=\"title\">Home | Strapizzami</title><link rel=\"icon\" type=\"image/x-icon\" href=\"/assets/logo1024.png\"><meta name=\"theme-color\" content=\"#000000\"/><meta name=\"description\" content=\"Strapizzami di Travacò Siccomario, Pavia apre le sue porte e ti accoglie nel suo personalissimo sito web! Esplora il nostro ricco menù, informati sulle nostre novità e molto altro! Strapizzami è un Ristorante / Pizzeria situato a Travacò siccomario in provincia di Pavia. Che aspetti? Vieni a trovarci! Siamo in via Marconi 64, Travacò sicc. (PV); Oppure ordina direttamente da casa tua, consegnamo anche a San Martino Siccomario e frazioni vicine!\"/><meta name=\"keywords\" content=\"Pizzeria, Pavia, Ristorante, Travacò siccomario\"/><link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx\" crossorigin=\"anonymous\"><link rel=\"preconnect\" href=\"https://fonts.googleapis.com\"><link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin><link href=\"https://fonts.googleapis.com/css2?family=Catamaran:wght@100;200;300;400;500;600;700;800;900&display=swap\" rel=\"stylesheet\"><script src=\"https://kit.fontawesome.com/f52b.js\" crossorigin=\"anonymous\"></script><script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script><script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script><script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script><style>*{font-family:'Catamaran', sans-serif;--brown:#662424;--red:#E82C34;--green:#2E8B57;--gray:#F8F9FA;--orange:#FFAA00}.classe-title{width:100%;text-align:center;padding-top:10%;padding-bottom:3%;font-weight:bold}.format-container{text-align:right;padding-right:2%}.format-text{text-align:right;}.food-container{padding-left:1%;padding-right:1%}.food{display:grid;grid-template-columns:60% 40%}.food-name{}.food-price{text-align:right}@keyframes cambiacolore{0%{color:var(--brown);}25%{color:var(--red);}50%{color:var(--orange);}75%{color:var(--red);}100%{color:var(--brown);}}.classe-title-special{width:100%;text-align:center;padding-top:10%;padding-bottom:3%;font-weight:bold;animation-name:cambiacolore;animation-duration:5s;animation-iteration-count:infinite}</style></head><body><div id=\"all\"><div id=\"navbar\" style=\"min-height:10vh\"><nav class=\"navbar bg-light fixed-top\"><div class=\"container-fluid\"><a class=\"navbar-brand fs-4\" style=\"margin-right:5vw;font-weight:800;\" href=\"/home\"><img src=\"assets/logo1024.png\" alt=\"\" width=\"30\" height=\"30\" class=\"d-inline-block align-text-top\">Strapizzami</img></a><button class=\"navbar-toggler\" style=\"border:none;box-shadow:none\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\"><img src=\"assets/list.svg\" width=\"30\" height=\"30\" class=\"d-inline-block\"></img></button><div class=\"collapse navbar-collapse fs-5\" style=\"align-items:center;text-align:center\" id=\"navbarNav\"><ul class=\"navbar-nav\"><li class=\"nav-item\"><a class=\"nav-link active\" aria-current=\"page\" href=\"/home\">Home</a></li><li class=\"nav-item\"><a class=\"nav-link\" href=\"/menu\">Menù</a></li><li class=\"nav-item\"><a class=\"nav-link\" href=\"/contatti\">Contatti</a></li></ul></div></div></nav></div><div style=\"min-height:100vh;padding-top:8em;padding-bottom:8em\">";
		
		String content = "";
		
		ArrayList<Classe> classi = PersistenceFacade.getInstance().getClassi();
		ArrayList<Pizza> pizzas = PersistenceFacade.getInstance().getPizzas();
		ArrayList<Dish> dishes = PersistenceFacade.getInstance().getDishes();
		ArrayList<Drink> drinks = PersistenceFacade.getInstance().getDrinks();
		
		if(classi != null && pizzas != null && dishes != null && drinks != null) {
			for(int i = 0; i<classi.size(); i++) {
				content += getClasseHtmlRepr(classi.get(i).getName(), classi.get(i).getName());
				//get pizza e alimento by classe
			}
			
			for(int j = 0; j < drinks.size(); j++) {
				content += getClasseHtmlRepr("Bevande", null);
				//get drink by price
			}
		}
		
		
		String second_half = "</div><div style=\"text-align:center\"><img src=\"assets/strapizzamiCar.gif\" alt=\"\" width=\"300em\" height=\"auto\" class=\"d-inline-block\"></img></div><div id=\"footer\" style=\"min-height:fit-content;position:relative;bottom:0\"><footer class=\"bg-dark text-center text-white\"><b class=\"fs-5\">strapizzami</b><br><i style=\"font-size:0.7em\">strapizzami.travaco.web.app@gmail.com</i><br><i style=\"font-size:0.7em\">+39 338 169 7359</i><br><div style=\"background-color:rgba(0, 0, 0, 0.2)\"><i style=\"font-size:0.75em\">Copyright © 2019-2022, strapizzami.it</i></div></footer></div></div><script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa\" crossorigin=\"anonymous\"></script></body></html>";
		return first_half + content + second_half;
	}
	
	private String getFoodHtmlRepr(String nome, ArrayList<String> prezzi, ArrayList<String> ingredienti) {
		/*
		 *<div class="food-container">
		 *	<div class="food">
		 *  	<div class="food-name"><h3>nome alimento</h3></div>    
		 *      <div class="food-price"><h3>0.00 0.00 0.00</h3></div>
		 *  </div>       
		 *  <div class="ingredients"><h6>(ingre1, ingre2..)</h6></div>
		 *</div>     
		 */
		String r = "<div class=\"food-container\">";
		r += "<div class=\"food\">";
		r += "<div class=\"food-name\"><h3>" + nome + "</h3></div>";
		r += "<div class=\"food-price\">";
		
		if(prezzi != null) {
			for(int i = 0; i < prezzi.size(); i++) {
				r += prezzi.get(i);
				if(i != prezzi.size()-1) r += " ";
			}
		}
		
		r += "</h3></div>";
		r += "</div>";
		r += "<div class=\"ingredients\"><h6>(";
		
		if(ingredienti != null) {
			for (int j = 0; j < ingredienti.size(); j++) {
				r += ingredienti.get(j);
				if(j != ingredienti.size()-1) r += ", ";
			}
		}
		
		r += ")</h6></div>";
		r += "</div>";
		return r;
	}
	private String getClasseHtmlRepr(String nome_classe, String descrizione_classe) {
		/*
		 *<div class="classe-container">
		 *	<div class="classe-title">
		 *		<h1>NOME CLASSE</h1>
		 *		<h3>&nbsp; descrizione classe &nbsp;</h3>
		 *	</div>
		 *</div>
		 */
		String r = "";
		r += "<div class=\"classe-container\">";
		r += "<div class=\"classe-title\">";
		r += "<h1>" + nome_classe + "</h1>";
		r += "<h3>&nbsp; " + descrizione_classe == null ? "" : descrizione_classe + " &nbsp;</h3>";
		r += "</div>";
		r += "</div>";
		return r;
	}
	private String getFormatsHtmlRepr(ArrayList<String> nomi) {
		/*
		 * <div class="format-container">
		 * 		<h6 class="format-text">normal-baby-family</h6>
		 * </div>
		 */
		if(nomi == null) return "";
		String r = "<div class=\"format-container\">";
		r += "<h6 class=\"format-text\">";
		for(int i = 0; i<nomi.size(); i++) {
			r += nomi.get(i);
			if(i != nomi.size()-1) r+= "-";
		}
		r += "</h6>";
		r += "</div>";
		return r;
	}
}
