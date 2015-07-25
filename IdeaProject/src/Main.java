import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

class MainWindow extends JFrame {
    MainWindow() {
        super("This is Main window");

        JLabel label = new JLabel("Hello");
        JPanel panel = new JPanel();
        panel.add(label);
        MainWindow mw = new MainWindow();
        mw.add(panel);


        /*
            For Exiting with escape key
        */

        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"
        );
        getRootPane().getActionMap().put("Cancel", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}

class District {
    private static String name;

    public void setDistrict(String distName) {
        this.name = distName;
    }

    public String getDist() {
        return name;
    }
}


public class Main {
    public static void main(String[] args) {
        District dist = new District();
        dist.setDistrict("Dhaka");
        MainWindow mw = new MainWindow();
        mw.setVisible(true);
        mw.setSize(400, 400);
        mw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
