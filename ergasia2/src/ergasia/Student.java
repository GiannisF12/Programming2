package ergasia;

import java.util.ArrayList;
import java.util.Scanner;

import ergasia.InvalidGradeException;
import ergasia.InvalidYearException;

public class Student extends Person {
	private String university;

	private String department;

	private int year;

	private ArrayList<Float> grades;

	
	public Student(String name, String surname, String am, String university, String department, int year) {
		super(name, surname, am);
		this.university = university;
		this.department = department;
		this.year = year;
		this.grades = new ArrayList<Float>();
	}

	
	public ArrayList<Float> getGrades() { 
		return grades;
	}

	
	public String getUniversity() {
		return university;
	}

	
	public void setUniversity(String university) {
		this.university = university;
	}

	
	public String getDepartment() {
		return department;
	}

	
	public void setDepartment(String department) {
		this.department = department;
	}

	
	public int getYear() {
		return year;
	}

	
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public void write() {
		super.write();
		System.out.println("University: " + university);
		System.out.println("Department: " + department);
		System.out.println("Year: " + year);
		
		// Grades are inserted by going from i = 0 until i < year so they are always
		// from year 1 and up in order. 
		int yearCounter = 1;
		for (float grade : grades) {
			System.out.println("Grade for year " + yearCounter + ": " + grade);
			yearCounter++;
		}
		
		System.out.println("Average grade: " + getAverageGrade());
	}

	@Override
	public void setGrade() throws InvalidGradeException {
		Scanner scanner = GlobalScanner.getScanner();
		float grade = 0;

		for (int i = 0; i < year; i++) {

			System.out.print("Insert final grade for year " + (i+1) + ": ");

			try {
				grade = scanner.nextFloat();
			} catch (Exception e) {
				throw new InvalidGradeException("\nInserted grade is invalid!", e);
			}

			grades.add(grade);
		}
	}

	@Override
	public float getAverageGrade() {
		float sum = 0;
		
		for (float grade : grades) {
			sum += grade;
		}

		if (grades.size() == 0) {
			return 0;
		}

		return sum / grades.size();
	}

	
	public static Student create() throws InvalidYearException {
		Scanner scanner = GlobalScanner.getScanner();

		System.out.print("Insert name: ");
		String name = scanner.nextLine();

		System.out.print("Insert surname: ");
		String surname = scanner.nextLine();

		System.out.print("Insert am: ");
		String am = scanner.nextLine();

		System.out.print("Insert university: ");
		String university = scanner.nextLine();

		System.out.print("Insert department: ");
		String department = scanner.nextLine();

		int year = 0;
		while (year < 1 || year > 4) {
			System.out.print("Insert year (1 - 4): ");
			try {
				year = Integer.parseInt(scanner.nextLine());
			}
			catch (Exception e) {
				throw new InvalidYearException("\nInserted year is invalid!", e);
			}
		}
		return new Student(name, surname, am, university, department, year);
	}
}
