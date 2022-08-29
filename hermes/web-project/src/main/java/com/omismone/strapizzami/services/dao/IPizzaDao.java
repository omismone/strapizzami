package com.omismone.strapizzami.services.dao;

import com.omismone.strapizzami.model.Classe;
import com.omismone.strapizzami.model.Pizza;

import java.util.ArrayList;

public interface IPizzaDao {
    public ArrayList<Pizza> getPizzas();
    public ArrayList<Pizza> getPizzasByClasse(Classe classe);
    public ArrayList<Pizza> getPizzasByName(String name);
}
