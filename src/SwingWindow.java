import com.sun.source.tree.WhileLoopTree;

import javax.swing.*;
import java.awt.*;

public class SwingWindow extends JFrame implements Runnable{
    private JPanel mainPanel;
    private KeyDetector k;
    private Player p;
    public SwingWindow()
    {
        k = new KeyDetector();
        this.addKeyListener(k);
        p = new Player(k);
        setContentPane(mainPanel);
        setTitle("HALL WAY HAVOC");
        setSize(1920,1080);
        setLocation(0,0);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        this.setFocusable(true);
        this.setFocusable(true);

    }

    @Override
    public void run() {
        mainPanel.repaint();
    }
    public void paint(Graphics g)
    {
        Graphics2D graphic = (Graphics2D)g;
        super.paint(g);
        p.draw(graphic);
    }


}
