import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public abstract class App implements ActionListener
{
    static JFrame f1;
    static String PASS = "AHMED";
    static JTable table;
    static Scanner sc;
    
    static File f = new File("help.csv");


    public static long countLineJava8(String fileName) {

        Path path = Paths.get(fileName);
  
        long lines = 0;
        try {
  
            // much slower, this task better with sequence access
            //lines = Files.lines(path).parallel().count();
  
            lines = Files.lines(path).count();
  
        } catch (IOException e) {
            e.printStackTrace();
        }
  
        return lines;
  
    }
    
    
    public static void main(String[] args) throws Exception
    {
        
        String tryPass = JOptionPane.showInputDialog(f1, "Enter the Password to the vault","Password",JOptionPane.DEFAULT_OPTION);
        sc= new Scanner(f);
        
        if(PASS.equals(tryPass))
        {

            String menuItem = JOptionPane.showInputDialog(f1, "1. Add a new password \n 2. Retrieve an old password \n 3. Quit");
            int selection = Integer.parseInt(menuItem);
            switch(selection)
            {
                case 1:
                JFrame frame = new JFrame("MySpringDemp");  
                frame.setLocation(650,250);               
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
                Container contentPane = frame.getContentPane();  
                SpringLayout layout = new SpringLayout();  
                contentPane.setLayout(layout);  
                JLabel label = new JLabel("Application Name: "); 
                JLabel label1 = new JLabel("Username: ");  
                JLabel label2 = new JLabel("Password: ");  
                JTextField textField = new JTextField("", 15);
                JTextField textField1 = new JTextField("", 15);
                JTextField textField2 = new JTextField("", 15);
                textField.setSize(15, 15); 
                contentPane.add(label);
                contentPane.add(label1);
                contentPane.add(label2);    
                contentPane.add(textField);
                contentPane.add(textField1);
                contentPane.add(textField2);

                JButton submit = new JButton("Submit");
                


                contentPane.add(submit);



                //label  and textfield 
                layout.putConstraint(SpringLayout.WEST, label,100,SpringLayout.WEST, contentPane);  
                layout.putConstraint(SpringLayout.NORTH, label,100,SpringLayout.NORTH, contentPane);  
                layout.putConstraint(SpringLayout.WEST, textField,6,SpringLayout.EAST, label);  
                layout.putConstraint(SpringLayout.NORTH, textField,100,SpringLayout.NORTH, contentPane);
                
                //label1  and textfield1
                layout.putConstraint(SpringLayout.WEST, label1,0,SpringLayout.WEST, label);  
                layout.putConstraint(SpringLayout.NORTH, label1,70,SpringLayout.NORTH, label); 
                layout.putConstraint(SpringLayout.WEST, textField1, 6, SpringLayout.WEST, label1);
                layout.putConstraint(SpringLayout.NORTH, textField1, 50, SpringLayout.SOUTH, textField);
                layout.putConstraint(SpringLayout.WEST, textField1,6,SpringLayout.EAST, label1); 
                
                
                //label2  and textfield2
                layout.putConstraint(SpringLayout.SOUTH, label2,85,SpringLayout.NORTH, textField1); 
                layout.putConstraint(SpringLayout.WEST, label2,100,SpringLayout.WEST, contentPane);
                layout.putConstraint(SpringLayout.WEST, textField2, 100, SpringLayout.WEST, label2);
                layout.putConstraint(SpringLayout.NORTH, textField2, 50, SpringLayout.SOUTH, textField1);
                layout.putConstraint(SpringLayout.WEST, textField2,6,SpringLayout.EAST, label2); 


                //Button
                layout.putConstraint(SpringLayout.NORTH, submit, 50, SpringLayout.SOUTH, label2);
                layout.putConstraint(SpringLayout.WEST, submit, 190, SpringLayout.WEST, contentPane);


                //Frame
                layout.putConstraint(SpringLayout.EAST, contentPane,100,SpringLayout.EAST, textField2);  
                layout.putConstraint(SpringLayout.SOUTH, contentPane,100,SpringLayout.SOUTH, textField2); 
    
                submit.addActionListener(new ActionListener() { 
                    public void actionPerformed(ActionEvent e) { 
                      selectionButtonPressed();
                      frame.dispose();
                    }
        
                    private void selectionButtonPressed() {
                        try {
                            FileWriter writerObj = new FileWriter("help.csv", true);
                            String newRow = textField.getText()+","+textField1.getText()+","+textField2.getText();
                            writerObj.write("\n"+newRow);
                            writerObj.close();
                
                            System.out.println("================================\n"
                                    + "File successfully overwritten.");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        
            }} );
                frame.pack();  
                frame.setVisible(true);

                break;





                case 2:
                String[] Titles = {"Application Name","Username","Password"};
                long NumOfLines =  countLineJava8("help.csv");
                String[][] row = new String[(int) NumOfLines][3]; 
                for(int i=0; i<NumOfLines; i++)
                {
                    String[] tempLine = sc.nextLine().split(",");
                    row[i][0] = tempLine[0];
                    row[i][1] = tempLine[1];
                    row[i][2] = tempLine[2];

                    //System.out.println(row[i][1]); 
                }
                f1 = new JFrame("Vault");
                f1.setSize(300,300);
                f1.setLocation(750, 350);
                f1.setVisible(true);
                
                //Af1.setLayout(new BorderLayout());

                
                table = new JTable(row,Titles);
                //f1.add(table);
                f1.add(new JScrollPane(table));
                f1.pack();
                break;
                case 3:
                break;
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(f1, "Access Denied","Error",JOptionPane.ERROR_MESSAGE); 
        }


        
        


        
        

        
        
      
    }


    
}
