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
    private Rectangle hitbox;
    private KeyDetector input;
    private BufferedImage sprite;


    public Player(KeyDetector in) {
        x = 800;
        y = 650;
        h = 200;
        w = 200;
        hitbox = new Rectangle(x, y, w, h);
        input = in;
        try {
            sprite = ImageIO.read(new File("Sprites/Player.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void draw(Graphics g){
        if (input.isJump())
        {
            hitbox.setLocation(x, y - 300);
            g.drawImage(sprite, x, y - 300, w, h, null);
        }
        else
        {
            hitbox.setLocation(x, y);;
            g.drawImage(sprite, x, y,w, h, null);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }
}
