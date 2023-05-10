import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Player{
    private int x;
    private int y;
    private int h;
    private int w;
    private KeyDetector k;
    private BufferedImage sprite;
    private BufferedImage shoot;


    public Player(KeyDetector k) {
        x = 100;
        y = 100;
        h = 50;
        w = 50;
        this.k = k;

        try {
            sprite = ImageIO.read(new File("Sprites/temp.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            shoot = ImageIO.read(new File("Sprites/ball.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedImage getSprite() {
        return sprite;
    }
    public void draw(Graphics g)
    {
        g.drawImage(sprite, x, y,w, h, null);
        if (k.j)
        {
            g.drawImage(sprite, x, y + 10, w, y, null);

        }
    }


}
