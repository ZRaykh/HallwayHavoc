import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.text.DecimalFormat;

public class SwingWindow extends JPanel implements Runnable{
    private JPanel mainPanel;
    private KeyDetector input;
    private Player player;
    private Background background;
    private Obstacles obstacles;
    private Collisons collison;
    private ScreenStats screen;
    private double timeSurvived;
    private DecimalFormat df;
    private Font timerFont;
    private Scores scores;
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
        timeSurvived = 0;
        df = new DecimalFormat("0.00");
        try {
            timerFont = Font.createFont(Font.TRUETYPE_FONT, new File("Sprites/pixelFont.TTF")).deriveFont(50f);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        playing = true;
        scores = new Scores();
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
                timeSurvived += 0.01;
                if (timeSurvived % (int) timeSurvived > 0.6)
                {
                    timeSurvived -= 0.6;
                    timeSurvived ++;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(collison.collided())
            {
                playing = false;
                scores.addScore(timeSurvived + "");
                scores.closeWriter();
                repaint();
            }
        }
    }


    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D graphic = (Graphics2D)g;
        Graphics2D text = (Graphics2D) g;
        background.drawBackground(graphic);
        player.draw(graphic);
        obstacles.entityDrawer(graphic);
        text.setColor(Color.white);
        text.setFont(timerFont);
        text.drawString("Seconds Survived: " + df.format(timeSurvived), 75, 100);
        text.drawString("High Score: " + df.format(scores.getGreatestScore()), 1000, 100);
    }
}