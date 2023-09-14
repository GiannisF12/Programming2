package ergasia;

import ergasia.IWrite;
import ergasia.InvalidGradeException;


public abstract class Person implements IWrite {
	private String name;
	
	private String surname;
	
	private String am;
	
	
	public Person(String name, String surname, String am) {
		this.name = name;
		this.surname = surname;
		this.am = am;
	}
	
	@Override
	public void write() {
		System.out.println("Name: " + name);
		System.out.println("Surname: " + surname);
		System.out.println("AM: " + am);
	}
	
	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public String getSurname() {
		return surname;
	}

	
	public void setSurname(String surname) {
		this.surname = surname;
	}

	
	public String getAm() {
		return am;
	}

	
	public void setAm(String am) {
		this.am = am;
	}

	// eisagogi bathmo
	public abstract void setGrade() throws InvalidGradeException;
	
	// euresi MO
	public abstract float getAverageGrade();
}
