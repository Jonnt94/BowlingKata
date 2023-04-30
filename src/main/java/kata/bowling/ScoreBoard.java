package kata.bowling;

import java.util.List;

public class ScoreBoard {
    public int calculateScore(List<Integer> scores) {
        int runningTotal = 0;
        for (Integer score : scores) {
            runningTotal += score;
        }
      return runningTotal;
    }
}
