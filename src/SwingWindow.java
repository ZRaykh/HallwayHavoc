import javax.swing.*;
import java.awt.*;

public class SwingWindow extends JFrame implements Runnable{
    private JPanel mainPanel;
    private KeyDetector input;
    private Player player;
    private Background background;
    private ScreenStats screen;

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

    @Override
    public void run() {
        mainPanel.repaint();
    }
    /*public void paint(Graphics g)
    {
        Graphics2D graphic = (Graphics2D)g;
        super.paint(g);

        Thread bgUpdate = new Thread(() -> {
        while (true) background.updateBackground(g);
    });
        bgUpdate.run();
        Thread playerUpdate = new Thread(() -> {
            while (true)  player.draw(graphic);
        });
        playerUpdate.run();
    }
*/
    public void paint(Graphics g)
    {
        Graphics2D graphic = (Graphics2D)g;
        super.paint(g);
        background.updateBackground(g);
        player.draw(graphic);
    }

}
