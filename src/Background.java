import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Background
{
    private ScreenStats screen;
    private BufferedImage backGroundA;

    private int pos1;
    private int frontY;
    private int backY;
    private int width;

    public Background()
    {
        screen = new ScreenStats();
        pos1 = 0;
        frontY = screen.getLENGTH()- screen.getLENGTH()/4;
        backY = 0;
        width = screen.getWIDTH();
        try {
            backGroundA = ImageIO.read(new File("Sprites/BackgroundTestNew.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    public void drawBackground(Graphics g)
    {
        int pos2 = pos1 + screen.getWIDTH()/3;
        int pos3 = pos2 + screen.getWIDTH()/3;
        int pos4 = pos3 + screen.getWIDTH()/3;
        g.drawImage(backGroundA, pos1, frontY, 660, 400, null);
        g.drawImage(backGroundA, pos2, frontY, 660, 400, null);
        g.drawImage(backGroundA, pos3, frontY, 660, 400, null);
        g.drawImage(backGroundA, pos4, frontY, 660, 400, null);
        pos1 -= 10;
        if(pos1 <= -650)
        {
            pos1 = 0;
        }
    }
}
