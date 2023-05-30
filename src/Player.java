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
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void draw(Graphics g){
        if (input.isJump())
        {
            g.drawImage(sprite, x, y - 100, w, h, null);
        }
        else g.drawImage(sprite, x, y,w, h, null);
    }


}
