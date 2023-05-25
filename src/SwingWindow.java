import javax.swing.*;
import java.awt.*;

public class SwingWindow extends JPanel implements Runnable{
    private JPanel mainPanel;
    private KeyDetector input;
    private Player player;
    private Background background;
    private Obstacles obstacles;
    private ScreenStats screen;
    private Thread game;



    public SwingWindow()
    {
        int ShiftDist = 30;
        screen = new ScreenStats();
        input = new KeyDetector();
        this.addKeyListener(input);
        player = new Player(input);
        background = new Background(ShiftDist);
        obstacles = new Obstacles(ShiftDist);
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(screen.getWIDTH(), screen.getLENGTH()));
        this.setDoubleBuffered(true);
        startThread();

    }
    public void startThread()
    {
        game = new Thread(this);
        game.start();
    }

    @Override
    public void run() {

        while (game != null)
        {
            repaint();
        }
    }


    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D graphic = (Graphics2D)g;
        background.drawBackground(g);
        player.draw(graphic);
    }

}
