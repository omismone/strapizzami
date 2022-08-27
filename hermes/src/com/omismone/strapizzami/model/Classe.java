package com.omismone.strapizzami.model;

public class Classe {
    private String name;
    private String description;
    private Integer relevance;
    public Classe(String name, String description, Integer relevance){
        this.name = name;
        this.description = description;
        this.relevance = relevance;
    }
    public String getName(){
        return this.name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getRelevance() {
        return relevance;
    }
}
