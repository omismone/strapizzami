package com.omismone.strapizzami.model;

public class Admin {
	private String name, pass;
	
	public Admin(String name, String pass) {
		this.setName(name);
		this.setPass(pass);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@Override
	public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Admin other = (Admin) obj;
        if(other.getName().equals(this.name) && other.getPass().equals(this.pass))
        	return true;
        return false;
	}
	
}
