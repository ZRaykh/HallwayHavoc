import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class KeyDetector implements KeyListener {
    private static boolean jump;
    public KeyDetector() {
        jump = false;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            jump = true;
            ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
            executorService.schedule(KeyDetector::unJump, 500, TimeUnit.MILLISECONDS);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public boolean isJump() {
        return jump;
    }

    public static void unJump() {
        jump = false;
    }
}
