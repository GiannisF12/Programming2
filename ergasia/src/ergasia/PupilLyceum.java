package ergasia;

import java.util.Scanner;

import ergasia.InvalidClassException;
import ergasia.InvalidGradeException;

public class PupilLyceum extends Person {
	private String lyceum;
	
	private char pupilClass; // A B C

	private float[] grades;
	
	
	public PupilLyceum(String name, String surname, String am, String lyceum, char pupilClass) {
		super(name, surname, am);
		this.lyceum = lyceum;
		this.pupilClass = pupilClass;
		this.grades = new float[2];
	}
	
	
	public float[] getGrades() {
		return grades;
	}

	
	public String getLyceum() {
		return lyceum;
	}

	
	public void setLyceum(String lyceum) {
		this.lyceum = lyceum;
	}

	
	public char getPupilClass() {
		return pupilClass;
	}

	
	public void setPupilClass(char pupilClass) {
		this.pupilClass = pupilClass;
	}
	
	@Override
	public void write() {
		super.write();
		System.out.println("Lyceum: " + lyceum);
		System.out.println("Class: " + pupilClass);
		
		for (int i = 0; i < grades.length; i++) {
			System.out.println("Four-month period No. " + (i+1) + " grade: " + grades[i]);
		}
		
		System.out.printf("Class average: %.2f\n", PersonsList.getInstance().getPersonsClassAverage(this));
	}

	@Override
	public void setGrade() throws InvalidGradeException {
		Scanner scanner = GlobalScanner.getScanner();
		float grade = 0;

		for (int i = 0; i < grades.length; i++) {

			System.out.print("Insert final grade for Four-month period No. " + (i+1) + ": ");

			try {
				grade = Float.parseFloat(scanner.nextLine());
			} catch (Exception e) {
				throw new InvalidGradeException("\nInserted grade is invalid!", e);
			}

			grades[i] = grade;
		}
	}

	@Override
	public float getAverageGrade() {
		float sum = 0;
		
		for (float grade : grades) {
			sum += grade;
		}

		return sum / grades.length;
	}

	
	public static PupilLyceum create() throws InvalidClassException {
		Scanner scanner = GlobalScanner.getScanner();
		System.out.print("Insert name: ");
		String name = scanner.nextLine();

		System.out.print("Insert surname: ");
		String surname = scanner.nextLine();

		System.out.print("Insert am: ");
		String am = scanner.nextLine();

		System.out.print("Insert lyceum: ");
		String lyceum = scanner.nextLine();

		char pupilClass = '0';
		while (pupilClass != 'A' && pupilClass != 'B' && pupilClass != 'C') {
			System.out.print("Insert class (A - B - C): ");
			try {
				pupilClass = scanner.nextLine().charAt(0);
			}
			catch (Exception e) {
				throw new InvalidClassException("\nInserted class is invalid!", e);
			}
		}
		return new PupilLyceum(name, surname, am, lyceum, pupilClass);
	}
}
