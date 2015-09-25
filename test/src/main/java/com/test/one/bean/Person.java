package com.test.one.bean;

import java.io.Serializable;

public class Person implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String personName;
    
	public Person() {
		// TODO Auto-generated constructor stub
	}
    public Person(String personName) {
		super();
		this.personName = personName;
	}
    
	public Person(int id, int personAge) {
		super();
		this.id = id;
		this.personAge = personAge;
	}
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

    private int personAge;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (personAge != person.personAge) return false;
        if (!personName.equals(person.personName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + personName.hashCode();
        result = 31 * result + personAge;
        return result;
    }
	@Override
	public String toString() {
		return "Person [id=" + id + ", personName=" + personName + ", personAge=" + personAge + "]";
	}
}
