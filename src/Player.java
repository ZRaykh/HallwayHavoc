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
    private KeyDetector input;
    private BufferedImage sprite;
    private BufferedImage shoot;


    public Player(KeyDetector in) {
        x = 800;
        y = 800;
        h = 50;
        w = 50;
        input = in;

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
        if (input.jump)
        {
            g.drawImage(sprite, x, y + 10, w, y, null);
            input.jump = false;
        }
    }


}
