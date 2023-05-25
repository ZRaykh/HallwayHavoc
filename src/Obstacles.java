public class Obstacles {
    private final int SHIFTDIST;
    private final int SPACING;
    private ObstacleEntity[] entities;
    private ScreenStats screen;

    public Obstacles(int shift)
    {
        SHIFTDIST = shift;
        SPACING = 330;
        screen = new ScreenStats();
        entities = new ObstacleEntity[5];
    }

}
