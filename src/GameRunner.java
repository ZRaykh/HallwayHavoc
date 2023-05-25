import javax.swing.*;

public class GameRunner extends JFrame {
    public GameRunner()
    {
        setResizable(false);
        SwingWindow game = new SwingWindow();
        add(game);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

