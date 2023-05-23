import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Background
{
    private ScreenStats screen;
    private BufferedImage front;
    private BufferedImage back;
    private BufferedImage backGroundA1;
    private BufferedImage backGroundA2;
    private BufferedImage backGroundA3;
    private BufferedImage backGroundA4;

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
            front = ImageIO.read(new File("Sprites/TestBackground.jpg"));
            back = ImageIO.read(new File("Sprites/2x1-rectangle.png"));
            backGroundA1 = ImageIO.read(new File("Sprites/BackgroundTestNew.png"));
            backGroundA2 = ImageIO.read(new File("Sprites/BackgroundTestNew.png"));
            backGroundA3 = ImageIO.read(new File("Sprites/BackgroundTestNew.png"));
            backGroundA4 = ImageIO.read(new File("Sprites/BackgroundTestNew.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void drawBackground(Graphics g)
    {
        int pos2 = pos1 + screen.getWIDTH()/3 + 1;
        int pos3 = pos2 + screen.getWIDTH()/3 + 1;
        int pos4 = pos3 + screen.getWIDTH()/3 + 1;
        g.drawImage(backGroundA1, pos1, frontY, 660, 400, null);
        g.drawImage(backGroundA2, pos2, frontY, 660, 400, null);
        g.drawImage(backGroundA3, pos3, frontY, 660, 400, null);
        g.drawImage(backGroundA4, pos4, frontY, 660, 400, null);
        pos1 -= 5;
        if(pos1 <= -660)
        {
            pos1 = 0;
        }
    }
}
