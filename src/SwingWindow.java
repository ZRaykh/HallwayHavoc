import javax.swing.*;
import java.awt.*;

public class SwingWindow extends JFrame implements Runnable{
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
        setContentPane(mainPanel);
        setTitle("HALL WAY HAVOC");
        setSize(screen.getWIDTH(), screen.getLENGTH());
        setLocation(0,0);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        this.setFocusable(true);
        this.setFocusable(true);

    }
    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/60;
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

                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g)
    {
        Graphics2D graphic = (Graphics2D)g;
        super.paint(g);
        background.drawBackground(g);
        player.draw(graphic);
    }

}
