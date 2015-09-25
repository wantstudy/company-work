package com.test.one.bean;

public class Adult {
	
	private static final long serialVersionUID = 1L;
	private int id;
    private String personName;
    
	public Adult() {
		// TODO Auto-generated constructor stub
	}
    public Adult(String personName) {
		super();
		this.personName = personName;
	}
    
	public Adult(int id, int personAge) {
		super();
		this.id = id;
		this.personAge = personAge;
	}
	public Adult(Person t) {
		this.id = t.getId();
		this.personAge = t.getPersonAge();
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
        if (!(o instanceof Adult)) return false;

        Adult person = (Adult) o;

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
