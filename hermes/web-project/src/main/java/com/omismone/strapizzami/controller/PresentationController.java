package com.omismone.strapizzami.controller;

import java.util.ArrayList;
import java.util.Arrays;

import com.omismone.strapizzami.model.Classe;
import com.omismone.strapizzami.model.Dish;
import com.omismone.strapizzami.model.Drink;
import com.omismone.strapizzami.model.Pizza;
import com.omismone.strapizzami.services.PersistenceFacade;

public class PresentationController {
	private static PresentationController singleton;
	private String cache;
	
	private PresentationController() {
		cache = null;
	}
	
	public static PresentationController getInstance() {
		if(singleton == null) singleton = new PresentationController();
		return singleton;
	}
	
	/**
	 * @return menu html
	 */
	public String getMenu() {
		if(cache != null) return cache;
		String first_half = "<!DOCTYPE html> "
				+ "<html lang=\"it\"> "
				+ "    <head> "
				+ "        <meta charset=\"utf-8\" /> "
				+ "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" /> "
				+ "        <title id=\"title\">Home | Strapizzami</title> "
				+ "        <link rel=\"icon\" type=\"image/x-icon\" href=\"/assets/logo1024.png\" /> "
				+ "        <!--Google positioning--> "
				+ "        <meta name=\"theme-color\" content=\"#000000\" /> "
				+ "        <meta "
				+ "            name=\"description\" "
				+ "            content=\"Strapizzami di Travacò Siccomario, Pavia apre le sue porte e ti accoglie nel suo personalissimo sito web! Esplora il nostro ricco menù, informati sulle nostre novità e molto altro! Strapizzami è un Ristorante / Pizzeria situato a Travacò siccomario in provincia di Pavia. Che aspetti? Vieni a trovarci! Siamo in via Marconi 64, Travacò sicc. (PV); Oppure ordina direttamente da casa tua, consegnamo anche a San Martino Siccomario e frazioni vicine!\" "
				+ "        /> "
				+ "        <meta name=\"keywords\" content=\"Pizzeria, Pavia, Ristorante, Travacò siccomario\" /> "
				+ "        <!--Bootstrap--> "
				+ "        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx\" crossorigin=\"anonymous\" /> "
				+ "        <!--Font--> "
				+ "        <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\" /> "
				+ "        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin /> "
				+ "        <link href=\"https://fonts.googleapis.com/css2?family=Catamaran:wght@100;200;300;400;500;600;700;800;900&display=swap\" rel=\"stylesheet\" /> "
				+ "        <!--Icons--> "
				+ "        <script src=\"https://kit.fontawesome.com/f52b.js\" crossorigin=\"anonymous\"></script> "
				+ "        <!--Carousel--> "
				+ "        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script> "
				+ "        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script> "
				+ "        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script> "
				+ "        <!--Css--> "
				+ "        <style> "
				+ "            * { "
				+ "                font-family: \"Catamaran\", sans-serif; "
				+ "                --brown: #662424; "
				+ "                --red: #e82c34; "
				+ "                --green: #2e8b57; "
				+ "                --gray: #f8f9fa; "
				+ "                --orange: #ffaa00; "
				+ "            } "
				+ "            .classe-title { "
				+ "                width: 100%; "
				+ "                text-align: center; "
				+ "                padding-top: 10%; "
				+ "                padding-bottom: 3%; "
				+ "                color: var(--brown); "
				+ "                font-weight: bold; "
				+ "            } "
				+ "            .format-container { "
				+ "                text-align: right; "
				+ "                padding-right: 2%; "
				+ "            } "
				+ "            .format-text { "
				+ "                text-align: right; "
				+ "                color: var(--red); "
				+ "            } "
				+ "            .food-container { "
				+ "                padding-left: 1%; "
				+ "                padding-right: 1%; "
				+ "            } "
				+ "				@media (min-width: 900px) { "
				+ "    				.food-container {"
				+ "						padding-left: 25%; "
				+ "						padding-right: 25%; "					
				+ "					}"
				+ "    				.format-container {"
				+ "						padding-right: 27%; "					
				+ "					}"
				+ "				}"
				+ "            .food { "
				+ "                display: grid; "
				+ "                grid-template-columns: 50% 50%; "
				+ "            } "
				+ "            .food-name { "
				+ "                color: var(--red); "
				+ "            } "
				+ "            .food-price { "
				+ "                text-align: right; "
				+ "					color: var(--brown); "
				+ "            } "
				+ "            @keyframes cambiacolore { "
				+ "                0% { "
				+ "                    color: var(--brown); "
				+ "                } "
				+ "                25% { "
				+ "                    color: var(--red); "
				+ "                } "
				+ "                50% { "
				+ "                    color: var(--orange); "
				+ "                } "
				+ "                75% { "
				+ "                    color: var(--red); "
				+ "                } "
				+ "                100% { "
				+ "                    color: var(--brown); "
				+ "                } "
				+ "            } "
				+ "            .classe-title-special { "
				+ "                width: 100%; "
				+ "                text-align: center; "
				+ "                padding-top: 10%; "
				+ "                padding-bottom: 3%; "
				+ "                color: var(--brown); "
				+ "                font-weight: bold; "
				+ "                animation-name: cambiacolore; "
				+ "                animation-duration: 5s; "
				+ "                animation-iteration-count: infinite; "
				+ "            } "
				+ "        </style> "
				+ "    </head> "
				+ "    <body> "
				+ "        <div id=\"all\"> "
				+ "            <div id=\"navbar\" style=\"min-height: 10vh;\"> "
				+ "                <nav class=\"navbar bg-light fixed-top\"> "
				+ "                    <div class=\"container-fluid\"> "
				+ "                        <a class=\"navbar-brand fs-4\" style=\"margin-right: 5vw; font-weight: 800; color: var(--brown);\" href=\"/home\"> "
				+ "                            <img src=\"assets/logo1024.png\" alt=\"\" width=\"30\" height=\"30\" class=\"d-inline-block align-text-top\" />Strapizzami "
				+ "                        </a> "
				+ "                        <button "
				+ "                            class=\"navbar-toggler\" "
				+ "                            style=\"border: none; box-shadow: none;\" "
				+ "                            type=\"button\" "
				+ "                            data-bs-toggle=\"collapse\" "
				+ "                            data-bs-target=\"#navbarNav\" "
				+ "                            aria-controls=\"navbarNav\" "
				+ "                            aria-expanded=\"false\" "
				+ "                            aria-label=\"Toggle navigation\" "
				+ "                        > "
				+ "                            <img src=\"assets/list.svg\" width=\"30\" height=\"30\" class=\"d-inline-block\" /> "
				+ "                        </button> "
				+ "                        <div class=\"collapse navbar-collapse fs-5\" style=\"align-items: center; text-align: center;\" id=\"navbarNav\"> "
				+ "                            <ul class=\"navbar-nav\"> "
				+ "                                <li class=\"nav-item\"> "
				+ "                                    <a class=\"nav-link\" aria-current=\"page\" href=\"/home\">Home</a> "
				+ "                                </li> "
				+ "                                <li class=\"nav-item\"> "
				+ "                                    <a class=\"nav-link active\" href=\"/menu\">Menù</a> "
				+ "                                </li> "
				+ "                                <li class=\"nav-item\"> "
				+ "                                    <a class=\"nav-link\" href=\"/contatti\">Contatti</a> "
				+ "                                </li> "
				+ "                            </ul> "
				+ "                        </div> "
				+ "                    </div> "
				+ "                </nav> "
				+ "            </div> "
				+ " "
				+ "            <!--BODY CONTENT--> "
				+ " "
				+ "            <!-- sample: "
				+ "            <div class=\"classe-container\"> "
				+ "                <div class=\"classe-title\"> "
				+ "                    <h1>NOME CLASSE</h1> "
				+ "                    <h3>descrizione classe</h3> "
				+ "                </div> "
				+ "            </div> "
				+ " "
				+ "            <div class=\"format-container\"> "
				+ "                <h6 class=\"format-text\">normal-baby-family</h6> "
				+ "            </div> "
				+ " "
				+ "            <div class=\"food-container\"> "
				+ "                <div class=\"food\"> "
				+ "                    <div class=\"food-name\"><h3>nome alimentodfs</h3></div> "
				+ "                    <div class=\"food-price\"><h3>0.00 0.00 0.00</h3></div> "
				+ "                </div> "
				+ "                <div class=\"ingredients\"><h6>(ingre1, ingre2..)</h6></div> "
				+ "            </div> "
				+ "--> "
				+ "				<br><br>"
				+ "				<img src=\"assets/striscia.png\" alt=\"strapizzami banner\" height=\"125px\" width=\"auto\" style=\"display: block; margin-left: auto; margin-right: auto;\">"
				+ "            <div style=\"min-height: 100vh; padding-top: 2em; padding-bottom: 2em;\">";		
		String content = "";
		
		ArrayList<Classe> classi = PersistenceFacade.getInstance().getClassi();
		ArrayList<Drink> drinks = PersistenceFacade.getInstance().getDrinks();
		
		if(classi != null) {
			
			//food
			for(int i = 0; i<classi.size(); i++) {
				ArrayList<Pizza> pizzas = PersistenceFacade.getInstance().getPizzasByClasse(classi.get(i));
				if(pizzas != null && pizzas.size() != 0) {
					content += getClasseHtmlRepr(classi.get(i).getName(), classi.get(i).getDescription());
					//print formats
					ArrayList<String> formats = new ArrayList<String>();
					ArrayList<Pizza> first_pizza_with_every_format = PersistenceFacade.getInstance().getPizzasByName(pizzas.get(0).getName());
					if(first_pizza_with_every_format != null)
						if(first_pizza_with_every_format.size() != 0) {
							first_pizza_with_every_format.forEach(pizza -> {formats.add(pizza.getFormat().getName());}); //take first pizza all formats name
							content += getFormatsHtmlRepr(formats);
						}
					//print pizzas
					ArrayList<String> already_done_pizzas = new ArrayList<String>();
					for(int pizzas_indx = 0; pizzas_indx < pizzas.size(); pizzas_indx++) {
						if(already_done_pizzas.contains(pizzas.get(pizzas_indx).getName())) continue; //if a pizza with the same name was already done
						ArrayList<Pizza> actual_pizza_withall_formats = PersistenceFacade.getInstance().getPizzasByName(pizzas.get(pizzas_indx).getName());
						already_done_pizzas.add(actual_pizza_withall_formats.get(0).getName());
						ArrayList<String> ingredients = new ArrayList<String>();
						actual_pizza_withall_formats.get(0).getIngredients().forEach(ingre -> {ingredients.add(ingre.getName() + (ingre.getFrozen() ? '*':""));});
						
						ArrayList<String> prices = new ArrayList<String>();
						actual_pizza_withall_formats.forEach(pzza -> {prices.add(String.format("%.2f", pzza.getPrice()));});
						
						content += getFoodHtmlRepr(actual_pizza_withall_formats.get(0).getName(), prices, ingredients);
					}
				}

				ArrayList<Dish> dishes = PersistenceFacade.getInstance().getDishesByClasse(classi.get(i));
				if(dishes != null && dishes.size() != 0) {
					content += getClasseHtmlRepr(classi.get(i).getName(), classi.get(i).getDescription());
					
					for(int i2=0;i2<dishes.size();i2++) {
						ArrayList<String> ingredients2 = new ArrayList<String>();
						ArrayList<String> prices2 = new ArrayList<String>();
						prices2.add(String.format("%.2f",dishes.get(i2).getPrice()));
						if(dishes.get(i2).getIngredients() != null) {
							dishes.get(i2).getIngredients().forEach(ingredient2 -> {ingredients2.add(ingredient2.getName() + (ingredient2.getFrozen() ? '*':""));});
							content += getFoodHtmlRepr(dishes.get(i2).getName(), prices2, ingredients2);
						}else {
							content += getFoodHtmlRepr(dishes.get(i2).getName(), prices2, null);
						}
					}
				}
			}
			
			if(drinks != null) {
				//drink
				ArrayList<String> already_done_formats = new ArrayList<String>();
				for(int j = 0; j < drinks.size(); j++) {
					/*
					 * want: 
					 * 			Bevande
					 * 		 in [formato]
					 * 
					 * 		---list bevande di quel formato--
					 * 
					 * 			Bevande
					 * 		in [altro formato]
					 * 
					 * 		-- list ---
					 * 
					 * 			etc.
					 */
					
					String actual_format = drinks.get(j).getFormat();
					if(!already_done_formats.contains(actual_format)) {
						content += getClasseHtmlRepr("Bevande", "in " + actual_format);
						ArrayList<Drink> byformat = PersistenceFacade.getInstance().getDrinksByFormat(actual_format);
						String name_b = "";
						if(byformat != null) {
							for(int z = 0; z<byformat.size(); z++) {
								name_b = byformat.get(z).getName() + " (" + String.valueOf(byformat.get(z).getQuantity()) + "cl)";
								content += getFoodHtmlRepr(name_b, new ArrayList<String>(Arrays.asList(String.format("%.2f", byformat.get(z).getPrice()))), null);
							}
						}
						already_done_formats.add(actual_format);
					}
				}
			}
			
			ArrayList<String> info_prod = new ArrayList<String>();
			info_prod.add("*prodotto surgelato");
			
			content += "<br><br>";
			content += getFormatsHtmlRepr(info_prod);
			content += "<br>";

		}
		
		String second_half = "</div> "
				+ "            <!--/BODY CONTENT--> "
				+ " "
				+ "            <!-- Footer --> "
				+ "            <div style=\"text-align: center;\"> "
				+ "                <img src=\"assets/strapizzamiCar.gif\" alt=\"\" width=\"300em\" height=\"auto\" class=\"d-inline-block\" /> "
				+ "            </div> "
				+ "            <div id=\"footer\" style=\"min-height: fit-content; position: relative; bottom: 0;\"> "
				+ "                <footer class=\"bg-dark text-center text-white\"> "
				+ "                    <b class=\"fs-5\">strapizzami</b> "
				+ "                    <br /> "
				+ "                    <i style=\"font-size: 0.7em;\">strapizzami.travaco.web.app@gmail.com</i> "
				+ "                    <br /> "
				+ "                    <i style=\"font-size: 0.7em;\">+39 338 169 7359</i> "
				+ "                    <br /> "
				+ "                    <div style=\"background-color: rgba(0, 0, 0, 0.2);\"><i style=\"font-size: 0.75em;\">Copyright © 2019-2022, pizzeriastrapizzami.com</i></div> "
				+ "                </footer> "
				+ "            </div> "
				+ "            <!-- Footer --> "
				+ "        </div> "
				+ " "
				+ "        <!--Bootstrap--> "
				+ "        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa\" crossorigin=\"anonymous\"></script> "
				+ "    </body> "
				+ "</html>";
		cache = first_half + content + second_half;
		return cache;
	
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
		r += "<div class=\"food-name\"><h3>";
		r += nome;
		r += "</h3></div>";
		
		if(prezzi != null) {
			r += "<div class=\"food-price\"><h4>€&nbsp;";
			for(int i = 0; i < prezzi.size(); i++) {
				r += prezzi.get(i);
				if(i != prezzi.size()-1) r += "-";
			}
			r += "</h4></div>";
		}
		
		r += "</div>";
		
		
		if(ingredienti != null) {
			r += "<div class=\"ingredients\"><h6>(";
			for (int j = 0; j < ingredienti.size(); j++) {
				r += ingredienti.get(j);
				if(j != ingredienti.size()-1) r += ", ";
			}
			r += ")</h6></div>";
		}
		
		
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
		if(nome_classe.contains("ettimana")) r += "<div class=\"classe-title-special\">"; //un po' troppo hard coded mi sa
		else r += "<div class=\"classe-title\">";
		r += "<h1>" + nome_classe + "</h1>";
		if(descrizione_classe != null) {
			r += "<h3>&nbsp; " + descrizione_classe + " &nbsp;</h3>";
		}
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
