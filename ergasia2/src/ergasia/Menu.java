package ergasia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame1 fr1 = new Frame1();
				fr1.show();
				dispose();
			}
		});
		btnNewButton.setBounds(150, 91, 150, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Other");
		btnNewButton_1.setBounds(150, 125, 150, 23);
		contentPane.add(btnNewButton_1);
		
		JFormattedTextField frmtdtxtfldMenu = new JFormattedTextField();
		frmtdtxtfldMenu.setHorizontalAlignment(SwingConstants.CENTER);
		frmtdtxtfldMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmtdtxtfldMenu.setText("Menu");
		frmtdtxtfldMenu.setBounds(150, 31, 150, 23);
		contentPane.add(frmtdtxtfldMenu);
	}
}
