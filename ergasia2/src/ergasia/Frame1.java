package ergasia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class Frame1 extends JFrame {
	DefaultListModel<String> listModel;
	boolean flag; 
	
	
	public Frame1() {
		//initComponents();
		listModel = new DefaultListModel<>();
		flag = true;
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 73, 177, 297);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(0, 0, 177, 297);
		panel.add(list);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(197, 73, 289, 297);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(60, 62, 187, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Insert Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField_1.getText();
				if(str.equals("")|| str.equalsIgnoreCase("Type Here"))
				{
					textField_1.setText("Type Here"); //show message if text field is empty
				}
				else
				{
					listModel.addElement(str); //add string to listmodel
					list.setModel(listModel); //set listmodel to 
					textField_1.setText("");  //clear text field
					flag = true;
				}
			}
		});
		btnNewButton.setBounds(85, 93, 134, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save Data to File");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//writing to text file
				int val = list.getModel().getSize(); //get the size of jlist and store it
				PrintWriter writer = null;
				try
				{
					writer = new PrintWriter("List.txt");
					writer.println(val); //write size of jlist
					for(int i =0; i<val; i++)
					{
						writer.println(list.getModel().getElementAt(i)); //get the element from list
					}
				}
				catch(Exception ex)
				{
					System.out.println(""+ex);
				}
				finally
				{
					//forget to close file
					writer.close();				
				}
				
				
			}
		});
		btnNewButton_1.setBounds(85, 127, 134, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Remove");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//remove data from list
				listModel.removeAllElements();
				list.setModel(listModel);
			}
		});
		btnNewButton_2.setBounds(85, 195, 134, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Status");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//load data to list from text file
				if(flag)
				{
					BufferedReader br = null;
					try
					{
						br = new BufferedReader(new FileReader("List.txt"));
						int val = Integer.parseInt(br.readLine()); //read the first line from file
						for(int i = 0;i < val; i++)
						{
							String ss = br.readLine(); //read data from file
							listModel.addElement(ss);  //add data to list model
						}
						list.setModel(listModel); // store listmodel to list
						flag = false;
						
					}
					catch(Exception ex)
					{
						System.out.println(""+ex);
					}
					finally
					{
						try 
						{
							br.close();
						}
						catch(Exception ex)
						{
							System.out.println(""+ex);
						}
						
					}
				}
				
			}
		});
		btnNewButton_3.setBounds(85, 161, 134, 23);
		panel_1.add(btnNewButton_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setToolTipText("");
		panel_2.setBounds(169, 21, 99, 27);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JTextPane txtpnStudent = new JTextPane();
		txtpnStudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnStudent.setText("Student");
		txtpnStudent.setBounds(10, 0, 79, 27);
		panel_2.add(txtpnStudent);
		
		
	}
	

	
	
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
		
		
		private JPanel contentPane;
		private JTable table;
		private JTable table_1;
		private JTextField textField;
		private JTextField textField_1;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Frame1 frame = new Frame1();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
}
