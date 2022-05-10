package view;

import handler.ProductHandler;
import model.ProductModel;

import java.awt.*;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProductReportDashboard extends JFrame {

    private JPanel contentPane;

    public void populateInitialTable(JTable table, List<ProductModel> productModelList) {
        while(table.getRowCount() > 0)
        {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }
        int columns = 6;
        int count=0;
        for(ProductModel pModel : productModelList)
        {
            Object[] row = new Object[columns];
            row[0] = pModel.getId();
            row[1] = pModel.getName();
            row[2] = pModel.getPrice();
            row[3] = pModel.getLocation();

            count++;
            ((DefaultTableModel) table.getModel()).insertRow(count-1,row);
            }
        }


    public ProductReportDashboard() {
        List<ProductModel> productModelList = ProductHandler.getProductModelList();


        setTitle("Product Report Form");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 566, 339);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel title = new JLabel(" Product Report");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(30, 30);
        add(title);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 70, 500, 200);
        contentPane.add(scrollPane);
        JTable jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);


        scrollPane.setViewportView(jTable1);
        jTable1.setRowSelectionAllowed(false);
        jTable1.setFillsViewportHeight(true);
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setCellSelectionEnabled(false);
        jTable1.setSurrendersFocusOnKeystroke(true);

        jTable1.setModel(new DefaultTableModel(
                new Object[][] {
                        {null},
                        {null},
                        {null},
                        {null},
                        {null},
                        {null},
                        {null},
                        {null},
                        {null},
                        {null},
                },
                new String[] {
                        "ID",
                        "Name",
                        "Price",
                        "Location"

                }
        ));

        populateInitialTable(jTable1, productModelList);
        setVisible(true);
    }
}
