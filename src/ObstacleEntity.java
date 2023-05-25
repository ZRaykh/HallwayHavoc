import com.sun.source.tree.PackageTree;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ObstacleEntity {
    private final int SHIFTDIST;
    private boolean acivated;
    private int x;
    private int y;
    private int w;
    private int h;
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
        y = 800;
        w = 50;
        h = 50;
        SHIFTDIST = shift;
        acivated = false;
        try {
            spriteA = ImageIO.read(new File("Sprites/Green.png"));
            spriteB = ImageIO.read(new File("Sprites/Orange.png"));
            spriteC = ImageIO.read(new File("Sprites/Purple.png"));
            spriteD = ImageIO.read(new File("Sprites/Red.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        currentSprite = spriteA;
    }

    public void toggleSprite()
    {
        acivated = !acivated;
        if (acivated == true)
        {
            int spriteNum = (int) (Math.random() * 4);
        }
    }
    public void drawObstacle(Graphics g)
    {
        g.drawImage(currentSprite, x, y, w, h, null);
        x -= SHIFTDIST;
    }
}
