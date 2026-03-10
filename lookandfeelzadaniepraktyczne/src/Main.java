import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Main extends JFrame {

    public Main() {

        setTitle("Demo FlatLaf");
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createMenu();
        createUI();
    }

    private void createMenu() {

        JMenuBar menuBar = new JMenuBar();
        JMenu viewMenu = new JMenu("Widok");

        JMenuItem lightMode = new JMenuItem("Light Mode");
        JMenuItem darkMode = new JMenuItem("Dark Mode");

        lightMode.addActionListener(e -> changeTheme("light"));
        darkMode.addActionListener(e -> changeTheme("dark"));

        viewMenu.add(lightMode);
        viewMenu.add(darkMode);

        menuBar.add(viewMenu);

        setJMenuBar(menuBar);
    }

    private void createUI() {

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();

        JTextField textField = new JTextField(15);
        JButton button = new JButton("Kliknij");
        JCheckBox checkBox = new JCheckBox("zaznacz");

        topPanel.add(textField);
        topPanel.add(button);
        topPanel.add(checkBox);

        panel.add(topPanel, BorderLayout.NORTH);

        String[] columns = {"ID","Imię","Miasto"};

        Object[][] data = {
                {1,"mariusz","gorzów"},
                {2,"patryk","gorzów"},
                {3,"johnny","barlinek"},
                {4,"żydek","internat"}
        };

        JTable table = new JTable(new DefaultTableModel(data, columns));

        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        add(panel);
    }

    private void changeTheme(String theme) {

        try {

            if(theme.equals("dark")) {
                UIManager.setLookAndFeel(new FlatDarkLaf());
            } else {
                UIManager.setLookAndFeel(new FlatLightLaf());
            }

            Theme.saveTheme(theme);

            SwingUtilities.updateComponentTreeUI(this);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {

            String savedTheme = Theme.loadTheme();

            if(savedTheme.equals("dark"))
                UIManager.setLookAndFeel(new FlatDarkLaf());
            else
                UIManager.setLookAndFeel(new FlatLightLaf());

        } catch(Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}