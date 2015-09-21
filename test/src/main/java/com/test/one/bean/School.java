package com.test.one.bean;

import java.io.Serializable;

public class School implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String schoolName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof School)) return false;

        School school = (School) o;

        if (id != school.id) return false;
        if (schoolName != null ? !schoolName.equals(school.schoolName) : school.schoolName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (schoolName != null ? schoolName.hashCode() : 0);
        return result;
    }
}
