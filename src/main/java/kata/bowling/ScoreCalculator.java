package kata.bowling;

import java.util.List;

public class ScoreCalculator {
    public int calculate(List<Frame> frames) {
            int runningTotal = 0;
            for (Frame frame : frames) {
                runningTotal += frame.calculateScore();
            }
            return runningTotal;
    }
}