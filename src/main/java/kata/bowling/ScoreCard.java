package kata.bowling;

import java.util.ArrayList;
import java.util.List;

public class ScoreCard {
    private final List<FrameScore> frameScores;

    public ScoreCard(List<FrameScore> frameScores){
        this.frameScores = frameScores;

    }
    public int getTotalScore() {
        return this.frameScores.get(9).getFrameScore();

    }
    public List<FrameScore> getFrameScores(){
        return frameScores;
    }


    public static final class ScoreCardBuilder {
        private List<FrameScore> frameScores = new ArrayList<>();

        private ScoreCardBuilder() {
        }

        public static ScoreCardBuilder aScoreCard() {
            return new ScoreCardBuilder();
        }

        public ScoreCardBuilder withFrameScore(List<FrameScore> frameScores) {
            this.frameScores = frameScores;
            return this;
        }

        public ScoreCardBuilder appendWithFrameScore(FrameScore frameScore){
            this.frameScores.add(frameScore);
            return this;
        }

        public ScoreCard build() {
            return new ScoreCard(frameScores);
        }
    }
}
