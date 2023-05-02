import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {
    private int x;
    private int y;
    private BufferedImage sprite;

    public Player() {
        x = 0;
        y = 0;
        try {
            sprite = ImageIO.read(new File("temp.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedImage getSprite() {
        return sprite;
    }
}
