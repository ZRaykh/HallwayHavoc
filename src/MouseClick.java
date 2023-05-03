import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseClick  implements MouseListener {
    private boolean shoot;

    public MouseClick()
    {
        shoot = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        shoot = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public boolean isShoot() {
        return shoot;
    }
}
