import java.awt.*;

public class Obstacles {
    private int spacing;
    private ObstacleEntity[] entities;
    private ScreenStats screen;

    public Obstacles(int shift)
    {
        spacing = 0;
        screen = new ScreenStats();
        entities = new ObstacleEntity[5];
        entities[0] = new ObstacleEntity(shift);
        entities[0].toggleActive(spacing);
        entities[1] = new ObstacleEntity(shift);
        entities[2] = new ObstacleEntity(shift);
        entities[3] = new ObstacleEntity(shift);
        entities[4] = new ObstacleEntity(shift);
    }

    public void entityDrawer(Graphics g)
    {
        for (int i = 0; i < entities.length; i++)
        {
            spacing = 250 + ((int) (Math.random() * 10) * 150);
            if (entities[i].getX() <= -entities[i].getW())
            {
                entities[i].toggleInactive();
            }
            else if (entities[i].isActive())
            {
                entities[i].drawObstacle(g);
                if (i != 4)
                {
                    if(!entities[i + 1].isActive() && screen.getWIDTH() - entities[i].getX() >= spacing)
                    {
                        entities[i + 1].toggleActive(spacing);
                    }
                }
                if (i == 4)
                {
                    if(!entities[0].isActive() && entities[i].getX() < screen.getWIDTH() - spacing)
                    {
                        entities[0].toggleActive(spacing);
                    }
                }
            }
        }
    }
}
