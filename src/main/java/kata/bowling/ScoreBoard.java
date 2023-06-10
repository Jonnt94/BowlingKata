package kata.bowling;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScoreBoard {
    private final ScoreValidator scoreValidator;
    public ScoreBoard(ScoreValidator scoreValidator){
        this.scoreValidator = scoreValidator;
    }
    public int calculateScore(List<Integer> scores) {
        if (scoreValidator.validate(scores)) {
            int runningTotal = 0;
            for (Integer score : scores) {
                runningTotal += score;
            }
            return runningTotal;
        }
        return 0;
    }
}
