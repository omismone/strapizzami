package com.omismone.strapizzami.model;

public class Classe {
    private String name;
    private String description;
    private Integer relevance;
    public Classe(String name, String description, Integer relevance){
        this.name = name.toLowerCase();
        this.description = description.toLowerCase();
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
        return (compare(this.name, other.getName()) && compare(this.description,other.getDescription()) && compare(this.relevance,other.getRelevance()));
	}
	
	/**
	 * @return true if o1.equals(o2) is true OR both are null.
	 */
	private boolean compare(Object o1, Object o2) {
		return ((o1 == null && o2 == null) || o1.equals(o2));
	}
}
