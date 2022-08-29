package com.omismone.strapizzami.services.dao;

import com.omismone.strapizzami.model.Classe;
import com.omismone.strapizzami.model.Dish;

import java.util.ArrayList;

public interface IDishDao {
    public ArrayList<Dish> getDishes();
    public ArrayList<Dish> getDishesByClasse(Classe classe);
}
