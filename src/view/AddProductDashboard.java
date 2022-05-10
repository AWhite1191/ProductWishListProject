package view;

import handler.ProductHandler;
import model.ProductModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddProductDashboard
        extends JFrame
        implements ActionListener {

    // Components of the Form
    private Container c;
    private JLabel title;

    private JLabel idLabel;
    private JTextField idField;

    private JLabel nameLabel;
    private JTextField nameField;

    private JLabel priceLabel;
    private JTextField priceField;

    private JLabel locationLabel;
    private JTextField locationField;

    private JButton submit;

    // constructor, to initialize the components
    // with default values.
    public AddProductDashboard()
    {
        setTitle("Add Product Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Add Product Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        idLabel = new JLabel("Product ID");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        idLabel.setSize(200, 30);
        idLabel.setLocation(100, 100);
        c.add(idLabel);

        idField = new JTextField();
        idField.setFont(new Font("Arial", Font.PLAIN, 15));
        idField.setSize(200, 30);
        idField.setLocation(300, 100);
        c.add(idField);

        nameLabel = new JLabel("Product Name");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        nameLabel.setSize(200, 30);
        nameLabel.setLocation(100, 150);
        c.add(nameLabel);

        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 15));
        nameField.setSize(200, 30);
        nameField.setLocation(300, 150);
        c.add(nameField);

        priceLabel = new JLabel("Product Price");
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        priceLabel.setSize(200, 30);
        priceLabel.setLocation(100, 200);
        c.add(priceLabel);

        priceField = new JTextField();
        priceField.setFont(new Font("Arial", Font.PLAIN, 15));
        priceField.setSize(200, 30);
        priceField.setLocation(300, 200);
        c.add(priceField);


        locationLabel = new JLabel("Product Location");
        locationLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        locationLabel.setSize(200, 30);
        locationLabel.setLocation(100, 250);
        c.add(locationLabel);

        locationField = new JTextField();
        locationField.setFont(new Font("Arial", Font.PLAIN, 15));
        locationField.setSize(200, 30);
        locationField.setLocation(300, 250);
        c.add(locationField);


        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.PLAIN, 20));
        submit.setSize(200, 30);
        submit.setLocation(300, 350);
        submit.addActionListener(this);
        c.add(submit);

        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        String id = idField.getText();
        String name = nameField.getText();
        double price = Double.parseDouble(priceField.getText());
        String location = locationField.getText();


        ProductModel productModel = new ProductModel(Integer.parseInt(id),name,price,location);
        ProductHandler.addProduct(productModel);

        JOptionPane.showMessageDialog(null,"Product added successfully");
        setVisible(false);
    }
}

