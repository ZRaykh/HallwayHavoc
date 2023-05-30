import java.awt.*;

public class Collisons {
    private Player player;
    private Obstacles obstacles;

    public Collisons(Player p, Obstacles o)
    {
        player = p;
        obstacles = o;
    }

    public boolean collided()
    {
        for (int i = 0; i < obstacles.getEntities().length; i ++)
        {
            ObstacleEntity obstacle = obstacles.getEntities()[i];
            if (player.getHitbox().intersects(obstacle.getHitbox()))
            {
                return true;
            }
        }
        return false;
    }
}
