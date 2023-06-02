import javax.swing.*;

public class GameRunner extends JFrame {
    public static void main(String[] args) {
        GameRunner HallwayHavoc = new GameRunner();
    }

    public GameRunner()
    {
        setResizable(false);
        SwingWindow game = new SwingWindow();
        add(game);
        pack();
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

