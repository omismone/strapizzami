package com.omismone.strapizzami.controller;

import java.util.ArrayList;

import com.omismone.strapizzami.controller.utils.IPassChiper;
import com.omismone.strapizzami.controller.utils.PassChiper;
import com.omismone.strapizzami.model.Classe;
import com.omismone.strapizzami.model.Format;
import com.omismone.strapizzami.model.Ingredient;
import com.omismone.strapizzami.model.Pizza;
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
	
	public Boolean insertWeeklyPizza(String pizza_name, float price, String[] ingredients_name, String[] ingredients_price, Boolean[] ingredients_frozen) {
		// se c'è un carattere non valido annulla
		if(pizza_name.contains("/") || pizza_name.contains("'") || pizza_name.contains("\"")|| pizza_name.contains("`") ) return false;
		//get classe della pizza della settimana  
		Classe classe_settimana = null;
		for(int j = 0; j < PersistenceFacade.getInstance().getClassi().size(); j++) {
			if(PersistenceFacade.getInstance().getClassi().get(j).getName().contains("ettimana"))
				classe_settimana = PersistenceFacade.getInstance().getClassi().get(j);
		}
		if(classe_settimana == null) return false; // non c'è la classe pizza della settimana
		
		//getIngredients
		ArrayList<Ingredient> ingredienti = new ArrayList<Ingredient>();
		for(int i = 0; i< ingredients_name.length; i++) {
			// se c'è un carattere non valido annulla
			if(ingredients_name[i].contains("/") || ingredients_name[i].contains("'") || ingredients_name[i].contains("\"")|| ingredients_name[i].contains("`") ) return false;
			
			ingredienti.add(new Ingredient(ingredients_name[i],ingredients_frozen[i],Float.parseFloat(ingredients_price[i])));
		}
		
		Pizza weekly = new Pizza(pizza_name, new Format("normal"), classe_settimana, price ,ingredienti, true);
		return pf.insertPizza(weekly);
		//need to hide actual weekly pizza
	}
	public String getAdminPage() {
		String html = "";
		html += "<!doctype html>\n"
				+ "<html lang=\"it\">\n"
				+ "  <head>\n"
				+ "    <meta charset=\"utf-8\">\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
				+ "    <title id=\"title\">Amministrazione | Strapizzami</title>\n"
				+ "    <link rel=\"icon\" type=\"image/x-icon\" href=\"/assets/logo1024.png\">\n"
				+ "    <!--Google positioning-->\n"
				+ "    <meta name=\"theme-color\" content=\"#000000\"/>\n"
				+ "    <meta name=\"description\" content=\"Strapizzami di Travacò Siccomario, Pavia apre le sue porte e ti accoglie nel suo personalissimo sito web! Esplora il nostro ricco menù, informati sulle nostre novità e molto altro! Strapizzami è un Ristorante / Pizzeria situato a Travacò siccomario in provincia di Pavia. Che aspetti? Vieni a trovarci! Siamo in via Marconi 64, Travacò sicc. (PV); Oppure ordina direttamente da casa tua, consegnamo anche a San Martino Siccomario e frazioni vicine!\"/>\n"
				+ "    <meta name=\"keywords\" content=\"Pizzeria, Pavia, Ristorante, Travacò siccomario\"/>\n"
				+ "    <!--Bootstrap-->\n"
				+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx\" crossorigin=\"anonymous\">\n"
				+ "    <!--Font-->\n"
				+ "    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n"
				+ "    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n"
				+ "    <link href=\"https://fonts.googleapis.com/css2?family=Catamaran:wght@100;200;300;400;500;600;700;800;900&display=swap\" rel=\"stylesheet\">\n"
				+ "    <!--Css-->\n"
				+ "    <style>\n"
				+ "        *{\n"
				+ "            font-family: 'Catamaran', sans-serif;\n"
				+ "            --brown: #662424;\n"
				+ "            --red: #E82C34;\n"
				+ "            --green: #2E8B57;\n"
				+ "            --gray: #F8F9FA;\n"
				+ "            --darkgray: #708090; \n"
				+ "        }\n"
				+ "        @media screen and (min-width: 800px) {\n"
				+ "            .listone-pizze {\n"
				+ "                margin-left: 20%;\n"
				+ "                margin-right: 20%;\n"
				+ "            }\n"
				+ "        }\n"
				+ "        @media screen and (max-width: 799px) {\n"
				+ "            .listone-pizze {\n"
				+ "                margin-left: 5%;\n"
				+ "                margin-right: 5%;\n"
				+ "            }\n"
				+ "        }\n"

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
				+ "            .food-price { "
				+ "                text-align: right; "
				+ "					color: var(--brown); "
				+ "            } "
				
				+ "    </style>\n"
				+ "  </head>\n"
				+ "  <body>\n"
				+ "    <div id=\"all\">\n"
				+ "        <div id=\"navbar\" style=\"min-height: 10vh;\">\n"
				+ "            <nav class=\"navbar bg-light fixed-top\">\n"
				+ "                <div class=\"container-fluid\">\n"
				+ "                    \n"
				+ "                    <a class=\"navbar-brand fs-4\" style=\"margin-right: 5vw;  font-weight: 800; color: var(--brown);\" href=\"/home\">\n"
				+ "                        <img src=\"assets/logo1024.png\" alt=\"\" width=\"30\" height=\"30\" class=\"d-inline-block align-text-top\">Strapizzami</img>\n"
				+ "                    </a>\n"
				+ "                    <button class=\"navbar-toggler\" style=\" border: none; box-shadow: none;\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
				+ "                        <img src=\"assets/list.svg\" width=\"30\" height=\"30\" class=\"d-inline-block\"></img>\n"
				+ "                    </button>\n"
				+ "                    <div class=\"collapse navbar-collapse fs-5\" style=\"align-items: center; text-align: center;\" id=\"navbarNav\">\n"
				+ "                        <ul class=\"navbar-nav\">\n"
				+ "                        <li class=\"nav-item\">\n"
				+ "                            <a class=\"nav-link\" aria-current=\"page\" href=\"/home\">Home</a>\n"
				+ "                        </li>\n"
				+ "                        <li class=\"nav-item\">\n"
				+ "                            <a class=\"nav-link\" href=\"/menu\">Menù</a>\n"
				+ "                        </li>\n"
				+ "                        <li class=\"nav-item\">\n"
				+ "                            <a class=\"nav-link\" href=\"/contatti\">Contatti</a>\n"
				+ "                        </li>\n"
				+ "                        </ul>\n"
				+ "                    </div>\n"
				+ "                </div>\n"
				+ "            </nav>\n"
				+ "        </div>\n"
				+ "\n"
				+ "        <!--BODY CONTENT-->\n"
				+ "\n"
				+ "        <div style=\"min-height: 80vh; display: grid; grid-row: auto auto auto; margin-top: 20%;\">\n"
				+ "\n"
				+ "            <div class=\"new-pizza\" style=\"\">\n"
				+ "                <div class=\"titolo-form\" style=\"color: var(--brown); text-align: center;\"><h1>nuova pizza della settimana?</h1></div>\n"
				+ "\n"
				+ "                <section style=\"text-align: center;\">\n"
				+ "                    <div class=\"card-body py-5 px-md-5\">\n"
				+ "                        <form action=\"/amministrazione\" method=\"post\">\n"
				+ "                        <!-- nome input -->\n"
				+ "                        <div class=\"form-outline mb-4\">\n"
				+ "                            <input type=\"text\" name=\"name\" class=\"form-control\" style=\"text-align: center; width: 80%; margin-left:10%;\" placeholder=\"nome\" required />\n"
				+ "                            <label class=\"form-label\" for=\"form2Example1\"></label>\n"
				+ "                        </div>\n"
				+ "                        <!-- price input -->\n"
				+ "                        <div class=\"form-outline mb-4\">\n"
				+ "                            <input type=\"number\" name=\"price\" step=\"0.50\" class=\"form-control\" style=\"text-align: center;width: 80%; margin-left:10%;\" placeholder=\"prezzo\" required />\n"
				+ "                            <label class=\"form-label\" for=\"form2Example2\"></label>\n"
				+ "                        </div>\n"
				+ "                        <input type=\"text\" onkeyup=\"BuildFormFields(parseInt(this.value, 10));\" placeholder=\"numero ingredienti\" style=\"text-align: center;\" required />\n"
				+ "		                <div id=\"FormFields\" style=\"margin: auto;\"></div>\n"
				+ "\n"
				+ "                        </div>\n"
				+ "<br><br><br><div style=\"color:var(--brown); \"><h4>inserisci nuovamente le tue credenziali</h4></div>"
				+ "                        <!-- username input -->\n"
				+ "                        <div class=\"form-outline mb-4\">\n"
				+ "                            <input type=\"text\" name=\"username\" class=\"form-control\" style=\"text-align: center; width: 60%; margin-left:20%;\" placeholder=\"username\" required />\n"
				+ "                            <label class=\"form-label\" for=\"form2Example1\"></label>\n"
				+ "                        </div>\n"
				+ "                        <!-- password input -->\n"
				+ "                        <div class=\"form-outline mb-4\">\n"
				+ "                            <input type=\"password\" name=\"password\" class=\"form-control\" style=\"text-align: center; width: 60%; margin-left:20%;\" required />\n"
				+ "                            <label class=\"form-label\" for=\"form2Example1\">password</label>\n"
				+ "                        </div>\n"
				+ "                        <!-- Submit button -->\n"
				+ "                        <input type=\"submit\" class=\"btn btn-danger btn-block mb-4\" value=\"inserisci\" onclick=\"return confirm('ATTENZIONE: questa azione è irreversibile!\\nstai per aggiungere al sistema delle nuove informazioni, così facendo sostituirai quelle attuali.\\nsei sicuro di volerlo fare?\\n\\nclicca OK per proseguire.')\" />\n"
				+ "                        </form>\n"
				+ "                    </div>\n"
				+ "                </section>\n"
				+ "                <br>\n"
				+ "                <!-- Section: Design Block -->\n"
				+ "\n"
				+ "            </div>\n"
				+ "\n <br><br><br>"
				+ "            <div class=\"old-pizzas\">\n"
				+ "                <div class=\"classe\" style=\"color: var(--brown); text-align: center;\"><h1>Le Precedenti</h1></div>\n"
				+ "\n"
				+ "                <div class=\"listone-pizze\">\n"
				+ "\n"
				+ "                    <!--pizze qui-->\n";
				
				//get classe della pizza della settimana  
				Classe classe_settimana = null;
				for(int j = 0; j < PersistenceFacade.getInstance().getClassi().size(); j++) {
					if(PersistenceFacade.getInstance().getClassi().get(j).getName().contains("ettimana"))
						classe_settimana = PersistenceFacade.getInstance().getClassi().get(j);
				}
				if(classe_settimana == null) return "<html><head></head><body><h1>application server error</h1></body></html>"; // non c'è la classe pizza della settimana
				//print pizzes
				ArrayList<Pizza> pizzas = PersistenceFacade.getInstance().getPizzasByClasse(classe_settimana);
				if(pizzas != null && pizzas.size() != 0) {
					//print formats
					ArrayList<String> formats = new ArrayList<String>();
					ArrayList<Pizza> first_pizza_with_every_format = PersistenceFacade.getInstance().getPizzasByName(pizzas.get(0).getName());
					if(first_pizza_with_every_format != null)
						if(first_pizza_with_every_format.size() != 0) {
							first_pizza_with_every_format.forEach(pizza -> {formats.add(pizza.getFormat().getName());}); //take first pizza all formats name
							html += getFormatsHtmlRepr(formats);
						}
					//print pizzas
					
					//visible pizzas
					ArrayList<String> already_done_pizzas = new ArrayList<String>();
					for(int pizzas_indx = 0; pizzas_indx < pizzas.size(); pizzas_indx++) {
						if(already_done_pizzas.contains(pizzas.get(pizzas_indx).getName())) continue; //if a pizza with the same name was already done
						ArrayList<Pizza> actual_pizza_withall_formats = PersistenceFacade.getInstance().getPizzasByName(pizzas.get(pizzas_indx).getName());

						if(!actual_pizza_withall_formats.get(0).getVisible()) continue; 
						
						already_done_pizzas.add(actual_pizza_withall_formats.get(0).getName());
						ArrayList<String> ingredients = new ArrayList<String>();
						actual_pizza_withall_formats.get(0).getIngredients().forEach(ingre -> {ingredients.add(ingre.getName() + (ingre.getFrozen() ? '*':""));});
						
						ArrayList<String> prices = new ArrayList<String>();
						actual_pizza_withall_formats.forEach(pzza -> {prices.add(String.format("%.2f", pzza.getPrice()));});

						
						html += getFoodHtmlRepr(actual_pizza_withall_formats.get(0).getName(), prices, ingredients, "var(--red)");
					}
					
					//invisible pizzas
					already_done_pizzas = new ArrayList<String>();
					for(int pizzas_indx = 0; pizzas_indx < pizzas.size(); pizzas_indx++) {
						if(already_done_pizzas.contains(pizzas.get(pizzas_indx).getName())) continue; //if a pizza with the same name was already done
						ArrayList<Pizza> actual_pizza_withall_formats = PersistenceFacade.getInstance().getPizzasByName(pizzas.get(pizzas_indx).getName());

						if(actual_pizza_withall_formats.get(0).getVisible()) continue; 
						
						already_done_pizzas.add(actual_pizza_withall_formats.get(0).getName());
						ArrayList<String> ingredients = new ArrayList<String>();
						actual_pizza_withall_formats.get(0).getIngredients().forEach(ingre -> {ingredients.add(ingre.getName() + (ingre.getFrozen() ? '*':""));});
						
						ArrayList<String> prices = new ArrayList<String>();
						actual_pizza_withall_formats.forEach(pzza -> {prices.add(String.format("%.2f", pzza.getPrice()));});

						
						html += getFoodHtmlRepr(actual_pizza_withall_formats.get(0).getName(), prices, ingredients, "var(--darkgray)");
					}
				}

				
				
				
				
				
				
				
				html += "                </div>\n"
				+ "            </div>\n"
				+ "\n"
				+ "            <div class=\"logout-button\" style=\"display: flex; flex-flow: column nowrap; margin-left: 5%; margin-right: 5%; align-items: end;\">\n"
				+ "                <form action=\"/home\">\n"
				+ "                    <input type=\"submit\" class=\"btn btn-danger btn-block\" value=\"logout\"/>\n"
				+ "                </form>\n"
				+ "            </div>\n"
				+ "\n"
				+ "            <br><br>\n"
				+ "        \n"
				+ "        \n"
				+ "        </div>\n"
				+ "\n"
				+ "        <!-- Footer -->\n"
				+ "        <div style=\"text-align: center;\">\n"
				+ "            <img src=\"assets/strapizzamiCar.gif\" alt=\"\" width=\"300em\" height=\"auto\" class=\"d-inline-block\"></img>\n"
				+ "        </div>\n"
				+ "        <div id=\"footer\" style=\"min-height: fit-content; position: relative; bottom: 0;\">\n"
				+ "            <footer class=\"bg-dark text-center text-white\">\n"
				+ "                <b class=\"fs-5\" >strapizzami</b> \n"
				+ "                <i style=\"font-size: 0.7em; display: block;\">+39 338 169 7359</i>\n"
				+ "                <div style=\"background-color: rgba(0, 0, 0, 0.2); display: block;\"><i style=\"font-size: 0.75em;\">Copyright © 2019-2022, pizzeriastrapizzami.com</i></div>\n"
				+ "            </footer>\n"
				+ "        </div>\n"
				+ "        <!-- Footer -->\n"
				+ "    </div>\n"
				+ "\n"
				+ "    <!--Bootstrap-->\n"
				+ "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa\" crossorigin=\"anonymous\"></script>\n"
				+ "\n"
				+ "    <!--fill ingredients size-->\n"
				+ "    <script type=\"text/javascript\">\n"
				+ "\n"
				+ "		function BuildFormFields($amount)\n"
				+ "		{\n"
				+ "			var\n"
				+ "				$container = document.getElementById('FormFields'),\n"
				+ "				$item, $field, $i;\n"
				+ "                $max_input = 8;\n"
				+ "\n"
				+ "			$container.innerHTML = '';\n"
				+ "			for ($i = 0; $i < Math.min($amount,$max_input); $i++) {\n"
				+ "				$item = document.createElement('div');\n"
				+ "                $item.style.display = \"block\";\n"
				+ "                $item.style.marginTop = \"5%\";\n"
				+ "                \n"
				+ "\n"
				+ "				$field = document.createElement('input');\n"
				+ "                $field.style.display = \"block\";\n"
				+ "				$field.name = 'ingredientsName';\n"
				+ "                $field.style.margin = \"auto\";\n"
				+ "                $field.style.marginTop = \"2%\";\n"
				+ "				$field.type = 'text';\n"
				+ "                $field.placeholder = \"nome ingrediente\";\n"
				+ "                $field.style.textAlign = \"center\";\n"
				+ "                $field.required = true;\n"
				+ "				$item.appendChild($field);\n"
				+ "\n"
				+ "				$container.appendChild($item);\n"
				+ "			}\n"
				+ "		}\n"
				+ "        \n"
				+ "\n"
				+ "	</script>"
				+ "  </body>\n"
				+ "</html>";
		return html;
	}
	
	private String getFoodHtmlRepr(String nome, ArrayList<String> prezzi, ArrayList<String> ingredienti, String css_var_name_of_title_color) {
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
		r += "<div class=\"food-name\" style=\" color: " + css_var_name_of_title_color + " \"  ><h3>";
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
