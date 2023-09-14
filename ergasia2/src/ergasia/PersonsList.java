package ergasia;

import java.util.HashMap;


public class PersonsList {
	// metafora dedomenon metaiksi klasaion me private static instance
	private static PersonsList instance;

	
	private HashMap<String, Person> persons;
	
	
	private PersonsList() {
		persons = new HashMap<String, Person>();
	}
	
	
	public static PersonsList getInstance() {
		if (instance == null) {
			instance = new PersonsList();
		}
		
		return instance;
	}
	
	
	public boolean add(Person person) {
		if (personExists(person)) {
			return false;
		}
		
		persons.put(person.getAm(), person);
		return true;
	}
	
	
	public boolean remove(String am) {
		if (!persons.containsKey(am)) {
			return false;
		}
		
		persons.remove(am);
		return true;
	}
	
	
	public boolean update(Person person) {
		if (!personExists(person)) {
			return false;
		}
		
		persons.replace(person.getAm(), person);
		return true;
	}

	
	public Person searchAm(String am) {
		return persons.get(am);
	}

	
	public Person searchName(String name) {
		Person person = null;

		for (Person item : persons.values()) {
			String fullName = (item.getName() + " " + item.getSurname()).toLowerCase();
			if (name.toLowerCase().equals(fullName)) {
				return item;
			}
		}

		return person;
	}
	
	
	public boolean personExists(Person person) {
		return persons.containsKey(person.getAm());
	}

	
	public float getPersonsClassAverage(Person person) {
		if (person instanceof PupilGymnasium) {
			PupilGymnasium castedPerson = (PupilGymnasium) person;
			return getGymnasiumAverage(castedPerson.getPupilClass());
		}
		else if (person instanceof PupilLyceum) {
			PupilLyceum castedPerson = (PupilLyceum) person;
			return getLyceumAverage(castedPerson.getPupilClass());
		}

		return 0;
	}

	
	private float getLyceumAverage (char pupilClass) {
		float average = 0;
		int count = 0;

		for (Person value : persons.values()) {
			if (value instanceof PupilLyceum) {
				PupilLyceum person = (PupilLyceum) value;
	
				if (person.getPupilClass() == pupilClass) {
					average += person.getAverageGrade();
					count++;
				}
			}
		}
		
		if (count == 0) {
			return 0;
		}

		return average / count;
	}

	
	private float getGymnasiumAverage (char pupilClass) {
		float average = 0;
		int count = 0;

		for (Person value : persons.values()) {
			if (value instanceof PupilGymnasium) {
				PupilGymnasium person = (PupilGymnasium) value;
	
				if (person.getPupilClass() == pupilClass) {
					average += person.getAverageGrade();
					count++;
				}
			}
		}
		
		if (count == 0) {
			return 0;
		}

		return average / count;
	}

	
	public void printPersons() {
		for (Person person : persons.values()) {
			System.out.println("-------------");
			person.write();
			System.out.println("-------------");
		}
	}
}
