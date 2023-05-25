import java.awt.*;

public class ScreenStats {
    private final int WIDTH ;
    private final int LENGTH;

    public ScreenStats()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        WIDTH = screenSize.width;
        LENGTH = screenSize.height;
    }

    public int getLENGTH() {
        return LENGTH;
    }

    public int getWIDTH() {
        return WIDTH;
    }
}
