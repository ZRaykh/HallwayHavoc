import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Scores {
    private FileWriter writer;
    private Scanner scan;
    private ArrayList<String> scores;
    private File scoreList;

    public Scores()
    {
        scores = new ArrayList<String>();
        scores.add("0.00");
        try {
            scoreList = new File("ScoreList");
            scan = new Scanner(scoreList);
            while (scan.hasNextLine())
            {
                String str = scan.nextLine();
                scores.add(str);
            }
            writer = new FileWriter("ScoreList");
            for (int i = 1; i < scores.size(); i++)
            {
                writer.append(scores.get(i)).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addScore(String score)
    {
        try {
            writer.append(score).append("\n");
            scores.add(score);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public double getGreatestScore()
    {
        double greatest = Double.parseDouble(scores.get(0));
        for (int i = 1; i < scores.size(); i++)
        {
            double val = Double.parseDouble(scores.get(i));
            if(val > greatest)
            {
                greatest = val;
            }
        }
        return greatest;
    }

    public void closeWriter()
    {
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

