import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyDetector implements KeyListener {
    public boolean j;
    public KeyDetector() {
        j = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            j = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
