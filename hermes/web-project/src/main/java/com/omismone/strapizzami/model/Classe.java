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
    
	@Override
	public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Classe other = (Classe) obj;
        return (other.getName().equals(this.name) && other.getDescription().equals(this.description) && other.getRelevance() == this.relevance);
	}
}
