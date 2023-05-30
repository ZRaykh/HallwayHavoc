import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ObstacleEntity {
    private final int SHIFTDIST;
    private boolean active;
    private int x;
    private int y;
    private int w;
    private int h;
    private Rectangle hitbox;

    private ScreenStats screen;
    private BufferedImage spriteA;
    private BufferedImage spriteB;
    private BufferedImage spriteC;
    private BufferedImage spriteD;
    private BufferedImage currentSprite;

    public ObstacleEntity(int shift)
    {
        screen = new ScreenStats();
        x = 9999;
        y = 650;
        w = 100;
        h = 100;
        hitbox = new Rectangle(x, y, w, h);
        SHIFTDIST = shift;
        active = false;
        try {
            spriteA = ImageIO.read(new File("Sprites/Green.png"));
            spriteB = ImageIO.read(new File("Sprites/Orange.jpg"));
            spriteC = ImageIO.read(new File("Sprites/Purple.jpg"));
            spriteD = ImageIO.read(new File("Sprites/Red.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        currentSprite = spriteA;
    }

    public void toggleActive(int spacing)
    {
        active = true;
        int spriteVer = (int) (Math.random() * 4);
        if (spriteVer == 0)
        {
            currentSprite = spriteA;
        }
        if (spriteVer == 1)
        {
            currentSprite = spriteB;
        }
        if (spriteVer == 2)
        {
            currentSprite = spriteC;
        }
        if (spriteVer == 3)
        {
            currentSprite = spriteD;
        }
        x = screen.getWIDTH() + spacing;
        hitbox.setLocation(x, y);
    }

    public void toggleInactive()
    {
        active = false;
        x = 9999;
    }
    public void drawObstacle(Graphics g)
    {
        hitbox.setLocation(x - SHIFTDIST, y);
        g.drawImage(currentSprite, x, y, w, h, null);
        x -= SHIFTDIST;
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

    public boolean isActive() {
        return active;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }
}
