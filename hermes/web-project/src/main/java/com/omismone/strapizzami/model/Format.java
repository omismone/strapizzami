package com.omismone.strapizzami.model;

public class Format {
    private String name;

    public Format(String name){
        this.name = name == null ? null : name.toLowerCase();
    }
    public String getName(){
        return this.name;
    }
	@Override
	public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Format other = (Format) obj;
        return ((other.getName() == null && this.name == null) || other.getName().equals(this.name));
	}
}
