import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;


public class MenuExample extends JFrame implements ActionListener {

    private TextArea textArea = new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);

    private MenuBar menuBar = new MenuBar();
    private Menu File = new Menu();
    private MenuItem newFile = new MenuItem();
    private MenuItem openFile = new MenuItem();
    private MenuItem saveFile = new MenuItem();
    private MenuItem save_usFile = new MenuItem();
    private MenuItem close = new MenuItem();
    

    MenuExample(){
        this.setSize(500,300);
        this.setTitle("Java Notepad");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.textArea.setFont(new Font("Century Gothic", Font.BOLD, 12));
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(textArea);

        this.setMenuBar(this.menuBar);
        this.menuBar.add(File);
        this.File.setLabel("File");

        this.newFile.setLabel("New");
        this.newFile.addActionListener(this);
        this.newFile.setShortcut(new MenuShortcut(KeyEvent.VK_N, false));
        this.File.add(this.newFile);


        this.openFile.setLabel("Open    ");
        this.openFile.addActionListener(this);
        this.openFile.setShortcut(new MenuShortcut(KeyEvent.VK_O, false));
        this.File.add(this.openFile);

        this.saveFile.setLabel("Save    ");
        this.saveFile.addActionListener(this);
        this.saveFile.setShortcut(new MenuShortcut(KeyEvent.VK_S, false));
        this.File.add(this.saveFile);

        this.save_usFile.setLabel("Save Us ");
        this.save_usFile.addActionListener(this);
        this.save_usFile.setShortcut(new MenuShortcut(KeyEvent.VK_F, false));
        this.File.add(this.save_usFile);

        this.close.setLabel("Exit");
        this.close.setShortcut(new MenuShortcut(KeyEvent.VK_F4, false));
        this.close.addActionListener(this);
        this.File.add(this.close);
    }

    public void actionPerformed (ActionEvent e){
        if(e.getSource() == this.close)
            this.dispose();

        else if(e.getSource() == this.openFile){
            JFileChooser open = new JFileChooser();
            int option = open.showOpenDialog(this);

            if(option == JFileChooser.APPROVE_OPTION){
                this.textArea.setText("");

                try{
                    Scanner scan = new Scanner(new FileReader(open.getSelectedFile().getPath()));
                    while(scan.hasNext())
                        this.textArea.append(scan.nextLine()+"\n");
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }

                
            }
        }
        else if(e.getSource() == this.saveFile){
                try{
                    BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\user\\Documents\\blabla.txt"));
                    out.write(this.textArea.getText());
                    out.close();
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            
        }

        else if(e.getSource() == this.save_usFile){
            JFileChooser save_us = new JFileChooser();
            int option = save_us.showSaveDialog(this);
            
            
                try{
                    BufferedWriter out = new BufferedWriter(new FileWriter(save_us.getSelectedFile().getPath()));
                    out.write(this.textArea.getText());
                    out.close();
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            
        }


        else if(e.getSource() == this.newFile)
		{
			try {
				FileWriter myWriter = new FileWriter("C:\\Users\\user\\Documents\\blabla.txt");
				myWriter.write("edit this");
				myWriter.close();
				System.out.println("Successfully file created.");

                Scanner scan = new Scanner(new FileReader("C:\\Users\\user\\Documents\\blabla.txt"));
                    while(scan.hasNext())
                        this.textArea.append(scan.nextLine()+"\n");
			  } catch (Exception ex) {
				System.out.println("An error occurred.");
				ex.printStackTrace();
			  }
        }
    }

    public static void main(String args[]){
        MenuExample app = new MenuExample();
        app.setVisible(true);
    }
}