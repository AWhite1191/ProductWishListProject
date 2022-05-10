package view;

import menu.CreateMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginDashboard
        extends JFrame
        implements ActionListener {

    String fileName="user-details.txt";
    // Components of the Form
    private Container c;
    private JLabel title;

    private JLabel nameLabel;
    private JTextField nameField;

    private JLabel passwordLabel;
    private JPasswordField passwordField;

    private JButton loginBtn , registerNowBtn;

    // constructor, to initialize the components
    // with default values.
    public LoginDashboard()
    {
        setTitle("Login Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Login Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        nameLabel = new JLabel("User Name");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        nameLabel.setSize(200, 30);
        nameLabel.setLocation(100, 150);
        c.add(nameLabel);

        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 15));
        nameField.setSize(200, 30);
        nameField.setLocation(300, 150);
        c.add(nameField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordLabel.setSize(200, 30);
        passwordLabel.setLocation(100, 200);
        c.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordField.setSize(200, 30);
        passwordField.setLocation(300, 200);
        c.add(passwordField);


        loginBtn = new JButton("Login");
        loginBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        loginBtn.setSize(200, 30);
        loginBtn.setLocation(100, 250);
        loginBtn.addActionListener(this);

        registerNowBtn = new JButton("Register Now");
        registerNowBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        registerNowBtn.setSize(200, 30);
        registerNowBtn.setLocation(300, 250);
        registerNowBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterNowDashboard registerNowDashboard = new RegisterNowDashboard();
                setVisible(false);
            }
        });
        c.add(loginBtn);
        c.add(registerNowBtn);

        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        String name = nameField.getText();
        String pwd = passwordField.getText();
        boolean isSuccess = false;
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                String[] token = data.split(";");

                if(token[0].equals(name) && token[1].equals(pwd)) {
                    isSuccess = true;
                }
            }
            myReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        }

        if(isSuccess){
            JOptionPane.showMessageDialog(null, "Login successfully");
            setVisible(false);

            final JFrame frame = new JFrame("Product Wishlist");
            CreateMenu createMenu = new CreateMenu();
            frame.setJMenuBar(createMenu.createMenuBar());

            frame.setBounds(300, 90, 900, 600);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 300);
            frame.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Invalid Credentials");

        }
    }
}

