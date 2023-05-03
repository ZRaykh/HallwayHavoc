import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Player implements KeyListener  {
    private int x;
    private int y;
    private BufferedImage sprite;
    private BufferedImage shoot;

    private MouseClick click;

    public Player(MouseClick main) {
        x = 0;
        y = 0;
        click = main;
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
        g.drawImage(sprite,100,100,100, 100, null);
        if (click != null && click.isShoot())
        {
            g.drawImage(sprite,300,300,100, 100, null);
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
