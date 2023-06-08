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
    private BufferedImage playerJump;
    private BufferedImage playerRun1;
    private BufferedImage playerRun2;
    private BufferedImage currentSprite;
    private int swapCounter;

    public Player(KeyDetector in) {
        x = 800;
        y = 650;
        h = 250;
        w = 250;
        hitbox = new Rectangle(x, y, w, h);
        input = in;
        swapCounter = 0;
        try {
            playerJump = ImageIO.read(new File("Sprites/PlayerJump.png"));
            playerRun1 = ImageIO.read(new File("Sprites/PlayerRunA.png"));
            playerRun2 = ImageIO.read(new File("Sprites/PlayerRunB.png"));
            currentSprite = playerRun1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics g){
        if (input.isJump())
        {
            hitbox.setLocation(x, y - 300);
            g.drawImage(playerJump, x, y - 300, w, h, null);
        }
        else
        {
            hitbox.setLocation(x, y);
            g.drawImage(currentSprite, x, y,w, h, null);
            swapCounter++;
            if (swapCounter == 8)
            {
                if (currentSprite.equals(playerRun1))
                {
                    currentSprite = playerRun2;
                }
                else
                    currentSprite = playerRun1;
                swapCounter = 0;
            }
        }
    }

    public Rectangle getHitbox() {
        return hitbox;
    }
}
