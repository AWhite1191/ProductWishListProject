package view;

import model.UserModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterNowDashboard
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

    private JButton submit;

    // constructor, to initialize the components
    // with default values.
    public RegisterNowDashboard()
    {
        setTitle("Register Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Registeration Form");
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


        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.PLAIN, 20));
        submit.setSize(200, 30);
        submit.setLocation(100, 250);
        submit.addActionListener(this);

        c.add(submit);

        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        String name = nameField.getText();
        String pwd = passwordField.getText();

        UserModel userModel = new UserModel(name,pwd);

        String str = userModel.toString();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.append(str);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        JOptionPane.showMessageDialog(null,"Registeration successfully");

        LoginDashboard loginDashboard = new LoginDashboard();
        setVisible(false);
    }
}

