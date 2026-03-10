import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {

        UIManager.LookAndFeelInfo[] lafList = UIManager.getInstalledLookAndFeels();

        for (UIManager.LookAndFeelInfo laf : lafList) {
            System.out.println("Nazwa: " + laf.getName());
            System.out.println("Klasa: " + laf.getClassName());
            System.out.println("-------------------------");
        }
    }
}