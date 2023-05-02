import javax.swing.*;
import java.awt.*;

public class SwingWindow extends JFrame{
    private JPanel mainPanel;
    private Player p;
    public SwingWindow()
    {
        setContentPane(mainPanel);
        setTitle("HALL WAY HAVOC");
        setSize(450,300);
        setLocation(300,50);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        p = new Player();
    }

    public void paintComponent()
    {

    }
}
