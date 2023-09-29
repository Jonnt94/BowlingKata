package kata.bowling;

import java.util.ArrayList;
import java.util.List;

public class ScoreCard {
    private final int totalScore = 0;
    private final List<FrameScore> frameScore = new ArrayList<>();


    public int getTotalScore() {
        return totalScore;
    }
    public List<FrameScore> getFrameScores(){
        return frameScore;
    }
}
