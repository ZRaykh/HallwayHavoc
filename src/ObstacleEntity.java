import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ObstacleEntity {
    private final int SHIFTDIST;
    private boolean active;
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private Rectangle hitbox;

    private ScreenStats screen;
    private BufferedImage spriteA;
    private BufferedImage spriteB;
    private BufferedImage spriteC;
    private BufferedImage currentSprite;

    public ObstacleEntity(int shift)
    {
        screen = new ScreenStats();
        xPos = 9999;
        yPos = 650;
        width = 150;
        height = 250;
        hitbox = new Rectangle(xPos, yPos, width - 10, height - 10);
        SHIFTDIST = shift;//
        active = false;
        try {
            spriteA = ImageIO.read(new File("Sprites/Obstacle1.png"));
            spriteB = ImageIO.read(new File("Sprites/Obstacle2.png"));
            spriteC = ImageIO.read(new File("Sprites/Obstacle3.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        currentSprite = spriteA;
    }

    public void toggleActive(int spacing)
    {
        active = true;
        int spriteVer = (int) (Math.random() * 3);
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
        xPos = screen.getWIDTH() + spacing;
        hitbox.setLocation(xPos, yPos);
    }

    public void toggleInactive()
    {
        active = false;
        xPos = 9999;
    }
    public void drawObstacle(Graphics g)
    {
        hitbox.setLocation(xPos - SHIFTDIST, yPos);
        g.drawImage(currentSprite, xPos, yPos, width, height, null);
        xPos -= SHIFTDIST;
    }

    public int getX() {
        return xPos;
    }

    public int getWidth() {
        return width;
    }

    public boolean isActive() {
        return active;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }
}
