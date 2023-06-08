import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Background
{
    private final int SHIFTFDIST;
    private ScreenStats screen;
    private BufferedImage backGroundA;
    private int posX;
    private int posY;

    public Background(int shift)
    {
        screen = new ScreenStats();
        posX = 0;
        posY = -23;
        SHIFTFDIST = shift;
        try {
            backGroundA = ImageIO.read(new File("Sprites/GameBackground.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    public void drawBackground(Graphics g)
    {
        int pos2 = posX + screen.getWIDTH()/3;
        int pos3 = pos2 + screen.getWIDTH()/3;
        int pos4 = pos3 + screen.getWIDTH()/3;
        g.drawImage(backGroundA, posX, posY, screen.getWIDTH()/3, screen.getLENGTH(), null);
        g.drawImage(backGroundA, pos2, posY, screen.getWIDTH()/3, screen.getLENGTH(), null);
        g.drawImage(backGroundA, pos3, posY, screen.getWIDTH()/3, screen.getLENGTH(), null);
        g.drawImage(backGroundA, pos4, posY, screen.getWIDTH()/3, screen.getLENGTH(), null);
        posX -= SHIFTFDIST;
        if(posX <= -screen.getWIDTH()/3)
        {
            posX = 0;
        }
    }
}
