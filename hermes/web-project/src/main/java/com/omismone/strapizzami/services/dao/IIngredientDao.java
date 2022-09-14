package com.omismone.strapizzami.services.dao;

import com.omismone.strapizzami.model.Ingredient;

import java.util.ArrayList;

public interface IIngredientDao {
    public ArrayList<Ingredient> getIngredients();
    public Boolean insertIngredient(Ingredient ingredient);
}
