import menu.CreateMenu;
import view.LoginDashboard;

import javax.swing.*;

public class MainApplication {

    public static void main(String[] args) {
        /*
        final JFrame frame = new JFrame("Product Wishlist");
        CreateMenu createMenu = new CreateMenu();
        frame.setJMenuBar(createMenu.createMenuBar());

        frame.setBounds(300, 90, 900, 600);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setVisible(true);
*/
        LoginDashboard loginDashboard = new LoginDashboard();
    }
}