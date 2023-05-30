import javax.swing.*;
import java.awt.*;

public class SwingWindow extends JPanel implements Runnable{
    private JPanel mainPanel;
    private KeyDetector input;
    private Player player;
    private Background background;
    private Obstacles obstacles;
    private Collisons collison;
    private ScreenStats screen;
    private Thread game;
    private boolean playing;

    public SwingWindow()
    {
        int ShiftDist = 15;
        screen = new ScreenStats();
        input = new KeyDetector();
        this.addKeyListener(input);
        player = new Player(input);
        background = new Background(ShiftDist);
        obstacles = new Obstacles(ShiftDist);
        collison = new Collisons(player, obstacles);
        playing = true;
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
        while (game != null && playing)
        {
            repaint();
            try {
                game.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(collison.collided())
            {
                playing = false;
            }
        }
    }


    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D graphic = (Graphics2D)g;
        background.drawBackground(graphic);
        player.draw(graphic);
        obstacles.entityDrawer(graphic);
    }

}
