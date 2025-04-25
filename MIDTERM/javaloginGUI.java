
package MIDTERM;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class JavaGUI {



 public JavaGUI() {
        JFrame jFrame = new JFrame();

        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();
        JLabel labelUsername = new JLabel("Username:");
        JLabel labelPassword = new JLabel("Password:");
        JButton LogIn = new JButton("LogIn");
      

        jFrame.setLayout(new GridLayout(3, 2));
        jFrame.getContentPane().add(labelUsername);
        jFrame.getContentPane().add(username);
        jFrame.getContentPane().add(labelPassword);
        jFrame.getContentPane().add(password);
        jFrame.getContentPane().add(LogIn);
  

       LogIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = username.getText();
                String enteredPassword = new String(password.getPassword());

                int key = 3; 
                String encryptedEnteredPassword = passwordEncryption(enteredPassword, key);

   
                boolean correct = authenticateUser(enteredUsername, encryptedEnteredPassword);

                if (correct) {
                    JOptionPane.showMessageDialog(jFrame, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(jFrame, "Invalid username or password.");
                }
            }
        });
       
        jFrame.setBounds(600, 300, 400, 250);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static String passwordEncryption(String password, int key) {
        char[] chars = password.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] += key;
        }
        return new String(chars);
    }

    private boolean authenticateUser(String username, String encryptedPassword) {
        try (BufferedReader myReader = new BufferedReader(new FileReader("C:\\Users\\Eunace Faith Emactao\\OneDrive\\Desktop\\forJframePrac.txt"))) {
            String line;
            while ((line = myReader.readLine()) != null) {
                String[] userInfo = line.split(",");
                String storedUsername = userInfo[0];
                String storedEncryptedPassword = userInfo[1];

               
                if (username.equals(storedUsername) && encryptedPassword.equals(storedEncryptedPassword)) {
                    return true; 
                }
            }
        } catch (IOException e) {
            System.out.println("❌ An error occurred while reading the file.");
            e.printStackTrace();
        }
        return false; 
    }

    public static void main(String[] args) {
        new JavaGUI();
    }
}