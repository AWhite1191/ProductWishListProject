package menu;

import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class CreateMenu {


    public static JMenuBar createMenuBar() {

        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rdmi;
        JCheckBoxMenuItem cbmi;

        Queue<String> queue = new LinkedList<String>();
        queue.add("Add Product");
        queue.add("Modify Product");
        queue.add("Product Report");
        queue.add("Delete Product");
        queue.add("Exit");


        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the File Menu.
        menu = new JMenu("File");
        menuBar.add(menu);

        //a group of JMenuItems
        menuItem = new JMenuItem(queue.poll());
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddProductDashboard addProductDashboard = new AddProductDashboard();
            }
        });

        menuItem = new JMenuItem(queue.poll());
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModifyProductDashboard modifyProductDashboard = new ModifyProductDashboard();
            }
        });


        menuItem = new JMenuItem(queue.poll());
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductReportDashboard productReportDashboard = new ProductReportDashboard();
            }
        });

        menuItem = new JMenuItem(queue.poll());
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteProductDashboard deleteProductDashboard = new DeleteProductDashboard();
            }
        });

        menuItem = new JMenuItem(queue.poll());
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Thanks for using application");
                System.exit(-1);
            }
        });

        return menuBar;

    }

}
