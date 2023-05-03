import javax.swing.*;
import java.awt.*;

public class SwingWindow extends JFrame{
    private JPanel mainPanel;
    private MouseClick click;
    private Player p;
    public SwingWindow()
    {
        setContentPane(mainPanel);
        setTitle("HALL WAY HAVOC");
        setSize(450,300);
        setLocation(300,50);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        p = new Player(click);
        click = new MouseClick();
        addMouseListener(click);
        repaint();
    }

    public void paint(Graphics g)
    {
        Graphics2D graphic = (Graphics2D)g;
        super.paint(g);
        if (p != null)
        {
            p.draw(graphic);
        }
    }

}
