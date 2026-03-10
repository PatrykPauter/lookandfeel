import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {

        setTitle("Zmiana Look and Feel");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton b1 = new JButton("Przycisk 1");
        JButton b2 = new JButton("Przycisk 2");

        JComboBox<String> combo = new JComboBox<>();

        UIManager.LookAndFeelInfo[] lafs = UIManager.getInstalledLookAndFeels();

        for (UIManager.LookAndFeelInfo laf : lafs) {
            combo.addItem(laf.getName());
        }

        combo.addActionListener(e -> {
            int index = combo.getSelectedIndex();

            try {
                UIManager.setLookAndFeel(lafs[index].getClassName());
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        add(new JLabel("Wybierz styl:"));
        add(combo);
        add(b1);
        add(b2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}