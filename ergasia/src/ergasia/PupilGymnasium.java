package ergasia;

import java.util.Scanner;

import ergasia.InvalidClassException;
import ergasia.InvalidGradeException;

public class PupilGymnasium extends Person {
	private String gymnaseum;
	
	private char pupilClass; // A, B, C

	private float[] grades;
	
	
	public PupilGymnasium(String name, String surname, String am, String gymnaseum, char pupilClass) {
		super(name, surname, am);
		this.gymnaseum = gymnaseum;
		this.pupilClass = pupilClass;
		this.grades = new float[3];
	}

	
	public String getGymnaseum() {
		return gymnaseum;
	}

	
	public void setGymnaseum(String gymnaseum) {
		this.gymnaseum = gymnaseum;
	}

	
	public char getPupilClass() {
		return pupilClass;
	}

	
	public void setPupilClass(char pupilClass) {
		this.pupilClass = pupilClass;
	}

	
	public float[] getGrades() {
		return grades;
	}

	@Override
	public void write() {
		super.write();
		System.out.println("Gymnaseum: " + gymnaseum);
		System.out.println("Class: " + pupilClass);
		
		for (int i = 0; i < grades.length; i++) {
			System.out.println("Three-month period No. " + (i+1) + " grade: " + grades[i]);
		}
		
		System.out.printf("Class average: %.2f\n", PersonsList.getInstance().getPersonsClassAverage(this));
	}
	
	@Override
	public void setGrade() throws InvalidGradeException {
		Scanner scanner = GlobalScanner.getScanner();
		float grade = 0;

		for (int i = 0; i < grades.length; i++) {

			System.out.print("Insert final grade for Three-month period No. " + (i+1) + ": ");

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

	
	public static PupilGymnasium create() throws InvalidClassException {
		Scanner scanner = GlobalScanner.getScanner();
		System.out.print("Insert name: ");
		String name = scanner.nextLine();

		System.out.print("Insert surname: ");
		String surname = scanner.nextLine();

		System.out.print("Insert am: ");
		String am = scanner.nextLine();

		System.out.print("Insert gymansium: ");
		String gymnasium = scanner.nextLine();

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
		return new PupilGymnasium(name, surname, am, gymnasium, pupilClass);
	}
}
