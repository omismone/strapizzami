package com.omismone.strapizzami.services.dao;

import com.omismone.strapizzami.model.Drink;

import java.util.ArrayList;

public interface IDrinkDao {
    public ArrayList<Drink> getDrinks();
    public ArrayList<Drink> getDrinksByPrice(float price);
}
