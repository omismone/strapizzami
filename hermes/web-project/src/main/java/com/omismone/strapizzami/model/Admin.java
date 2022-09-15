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
        return (compare(this.name,other.getName()) && compare(this.pass,other.getPass()));
	}
	
	/**
	 * @return true if o1.equals(o2) is true OR both are null.
	 */
	private boolean compare(Object o1, Object o2) {
		return ((o1 == null && o2 == null) || o1.equals(o2));
	}
	
}
