package ergasia;

import java.util.Scanner;

import ergasia.GlobalScanner;
import ergasia.Person;
import ergasia.PersonsList;
import ergasia.PupilGymnasium;
import ergasia.PupilLyceum;
import ergasia.Student;
import ergasia.InvalidYearException;
import ergasia.MenuExample;

public class MainClass {

	// public static void main(String[] args) {
		
	// 	PersonsList list = PersonsList.getInstance();
	// 	Scanner sc = GlobalScanner.getScanner();
	// 	int choice = 999;

	// 	// Otan h epilogi den einai 0 sunexise tis erwtiseis
	// 	//  diaxeirish kathe lathos eisodou
	// 	do {
	// 		try {
	// 			printMenu();
	// 			System.out.print("Your choice: ");
	// 			choice = Integer.parseInt(sc.nextLine());
	// 			executeFunction(choice, list, sc);
	// 		} catch (Exception e) {
	// 			System.out.println("Invalid choice!\n");
	// 		}
	// 	} while(choice != 0);
	// 	System.out.println("\nGoodbye!\n");
	// }

	// Ektupwsh menu
	protected static void printMenu() {
		System.out.println("\nChoose by inserting the corresponding number: ");
		System.out.println("1. Insert gymnasium pupil");
		System.out.println("2. Insert lyceum pupil");
		System.out.println("3. Insert university student");
		System.out.println("4. Students/Pupils status");
		System.out.println("5. Search using full name");
		System.out.println("6. Search using AM");
		System.out.println("7. Update a student's/pupil's' details");
		System.out.println("8. Delete a student/pupil");
		System.out.println("9. Insert/modify grade by AM");
		System.out.println("0. Exit\n");
	}

	
	protected static void executeFunction(int choice, PersonsList list, Scanner scanner) throws InvalidYearException, InvalidClassException {
		String term = "";
		String am = "";
		switch (choice) {
			case 1:
				addGymnasiumPupil(list);
				break;
			case 2:
				addLyceumPupil(list);
				break;
			case 3:
				addStudent(list);
				break;
			case 4:
				list.printPersons();
				break;
			case 5:
				System.out.print("Insert the full name to search: ");
				System.out.println("");
				term = scanner.nextLine();
				fullNameSearch(term, list);
				break;
			case 6:
				System.out.print("Insert the AM to search: ");
				System.out.println("");
				term = scanner.nextLine();
				amSearch(term, list);
				break;
			case 7:
				System.out.print("Insert the AM of the student/pupil to update: ");
				System.out.println("");
				am = scanner.nextLine();
				Person person = list.searchAm(am);

				// elegxos ean yparxei atomo 
				if (person != null) {
					person.write();
					System.out.println("\nInsert the new details.\n");

					if (person instanceof Student) {
						Student student = Student.create();

						updatePerson(person, student, list);
					}
					else if (person instanceof PupilGymnasium) {
						PupilGymnasium pupil = PupilGymnasium.create();

						updatePerson(person, pupil, list);
					}
					else {
						PupilLyceum pupil = PupilLyceum.create();

						updatePerson(person, pupil, list);
					}
				}
				else {
					System.out.println("\nNo person found with this AM!");
				}
				break;
			case 8:
				System.out.print("Insert the AM of the student/pupil to delete: ");
				am = scanner.nextLine();
				deletePerson(list, am);
				break;
			case 9:
				System.out.print("Insert the AM of the student/pupil to set grade to: ");
				am = scanner.nextLine();
				try {
					setGrade(am, list);
				} catch (InvalidGradeException e) {
					System.out.println(e.getMessage() + "\n");
				}
				break;
				case 10:
				MenuExample app = new MenuExample();
				app.setVisible(true);
				break;
			default:
				break;
		}
	}

	// prosthesh neou foititi
	protected static void addStudent(PersonsList list) {
		try {
			boolean result = list.add(Student.create());
			if (result) {
				System.out.println("\nStudent inserted!");
			}
			else {
				System.out.println("\nStudent not inserted...");
			}
		} catch (InvalidYearException e) {
			System.out.println(e.getMessage() + "\n");
		}
	}

	// prosthesh neou mathiti lykeiou
	protected static void addLyceumPupil(PersonsList list) {
		try {
			boolean result = list.add(PupilLyceum.create());
			if (result) {
				System.out.println("\nPupil inserted!");
			}
			else {
				System.out.println("\nPupil not inserted...");
			}
		} catch (InvalidClassException e) {
			System.out.println(e.getMessage() + "\n");
		}
	}

	// prosthesh neou mathiti gymnasiou
	protected static void addGymnasiumPupil(PersonsList list) {
		try {
			boolean result = list.add(PupilGymnasium.create());
			if (result) {
				System.out.println("\nPupil inserted!");
			}
			else {
				System.out.println("\nPupil not inserted...");
			}
		} catch (InvalidClassException e) {
			System.out.println(e.getMessage() + "\n");
		}
	}

	
	protected static void fullNameSearch(String name, PersonsList list) {
		Person person = list.searchName(name);
		checkOrPrintPerson(person);
	}

	
	protected static void amSearch(String am, PersonsList list) {
		Person person = list.searchAm(am);
		checkOrPrintPerson(person);
	}

	// elegxos gia tous uparxontes mathites 
	protected static void checkOrPrintPerson(Person person) {
		if (person == null) {
			System.out.println("\nStudent/Pupil not found...");
			return;
		}

		System.out.println("");
		person.write();
	}

	
	protected static void updatePerson(Person oldPerson, Person newPerson, PersonsList list) {
		if (!newPerson.getAm().equals(oldPerson.getAm())) {
			System.out.println("\nThe AM given is different!");
			return;
		}

		boolean result = list.update(newPerson);
		if (result) {
			System.out.println("\nUpdated successfully!");
		}
	}

	// afairesh atomou me anazitisi AM
	protected static void deletePerson(PersonsList list, String am) {
		boolean result = list.remove(am);

		if (result) {
			System.out.println("\nStudent/Pupil removed successfully!");
		}
		else {
			System.out.println("\nStudent/Pupil does not exist!");
		}
	}

	// anazitisi atomou me AM
	protected static void setGrade(String am, PersonsList list) throws InvalidGradeException {
		Person person = list.searchAm(am);

		if (person == null) {
			System.out.println("\nStudent/Pupil not found!");
			return;
		}

		person.setGrade();
		System.out.println("\nGrade changed successfully!");
	}
}


