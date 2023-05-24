import javax.swing.*;
import java.awt.*;

public class SwingWindow extends JPanel implements Runnable{
    private JPanel mainPanel;
    private KeyDetector input;
    private Player player;
    private Background background;
    private ScreenStats screen;
    private Thread gameThread;


    public SwingWindow()
    {
        screen = new ScreenStats();
        input = new KeyDetector();
        this.addKeyListener(input);
        player = new Player(input);
        background = new Background();
        this.setPreferredSize(new Dimension(screen.getWIDTH(), screen.getLENGTH()));
        this.setFocusable(true);
        this.setDoubleBuffered(true);
        startGameThread();

    }
    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/120;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null)
        {
            repaint();
            try
            {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000;
                if(remainingTime < 0)
                {
                    remainingTime = 0;
                }

                nextDrawTime += drawInterval;
                Thread.sleep((long) remainingTime);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
