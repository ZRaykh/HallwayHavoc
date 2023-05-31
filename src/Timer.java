import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Timer {
    private static int timeSurvived;
    private static boolean gameRunning;
    private static boolean timerRunning;

    public Timer()
    {
        timeSurvived = 0;
        gameRunning = false;
        timerRunning = true;
    }

    public void toggleGameRunning()
    {
        gameRunning = !gameRunning;
    }
    public void runTimer()
    {
        while (timerRunning)
        {
            ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
            executorService.schedule(Timer::addSecond, 1000, TimeUnit.MILLISECONDS);
        }
    }

    public static void addSecond()
    {
        if (gameRunning)
        {
            timeSurvived++;
            System.out.println(timeSurvived);
        }
    }

    public void draw(Graphics g) {
        g.drawString("Seconds Survived: " + timeSurvived, 0, 0);
    }
}
