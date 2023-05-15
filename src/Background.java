import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Background
{
    private ScreenStats screen;
    private BufferedImage front;
    private BufferedImage back;
    private int x;
    private int frontY;
    private int backY;
    private int width;

    public Background()
    {
        screen = new ScreenStats();
        x = 0;
        frontY = screen.getLENGTH()- screen.getLENGTH()/4;
        backY = 0;
        width = screen.getWIDTH();
        try {
            front = ImageIO.read(new File("Sprites/TestBackground.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            back = ImageIO.read(new File("Sprites/2x1-rectangle.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics g)
    {
        g.drawImage(front, x, frontY, width, screen.getLENGTH() - frontY, null);
        g.drawImage(back, x, backY, width, frontY, null);
    }

    public void updateBackground(Graphics g)
    {
        while (true)
        {
            draw(g);
            if (x < 420)
            {
                x += 5;
            }
            else
            {
                x = 0;
            }
        }
    }
}
