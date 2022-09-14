package com.omismone.strapizzami.services.dao;

import com.omismone.strapizzami.model.Classe;

import java.util.ArrayList;

public interface IClasseDao {
    public ArrayList<Classe> getClassi();
    public Boolean insertClasse(Classe classe);
}
