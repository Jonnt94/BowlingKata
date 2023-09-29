package kata.bowling;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreCalculatorTest {
    ScoreCalculator scoreCalculator = new ScoreCalculator();
    @Test
    void calculate_shouldReturnCorrectTotalWhenGivenFullMatchOfSimpleFrames() {
        Frames frames = new Frames(List.of(Frame.of(1,2), Frame.of(3,4), Frame.of(5,4), Frame.of(4,4), Frame.of(3,3), Frame.of(2,2), Frame.of(1,1), Frame.of(1,2), Frame.of(3,4), Frame.of(5,4)));

        int totalScore = scoreCalculator.calculate(frames);

        assertEquals(58,totalScore);
    }

    @Test
    void calculate_shouldReturnCorrectTotalWhenGivenFullMatchOfFramesIncludingSingleSpare() {
        Frames frames = new Frames(List.of(Frame.of(1,2), Frame.of(3,4), Frame.of(5,5), Frame.of(4,4), Frame.of(3,3), Frame.of(2,2), Frame.of(1,1), Frame.of(1,2), Frame.of(3,4), Frame.of(5,4)));

        int totalScore = scoreCalculator.calculate(frames);

        assertEquals(63,totalScore);
    }

    @Test
    void calculate_shouldReturnCorrectTotalWhenGivenFullMatchOfSpares() {
        Frames frames = new Frames(List.of(Frame.of(0,10),Frame.of(1,9), Frame.of(2,8), Frame.of(3,7), Frame.of(4,6), Frame.of(5,5), Frame.of(6,4), Frame.of(7,3), Frame.of(8,2), Frame.of(9,1), Frame.of(9,0)));

        int totalScore = scoreCalculator.calculate(frames);

        assertEquals(154,totalScore);
    }

    @Test
    void calculate_shouldReturnCorrectTotalWhenGivenFullMatchOfFramesIncludingSingleStrike(){
        Frames frames = new Frames(List.of(Frame.of(1,2), Frame.of(3,4), Frame.of(5,4), Frame.of(4,4), Frame.of(3,3), Frame.of(2,2), Frame.of(10, 0), Frame.of(1,2), Frame.of(3,4), Frame.of(5,4)));

        int totalScore = scoreCalculator.calculate(frames);

        assertEquals(69,totalScore);
    }

    @Test
    void calculate_shouldReturnCorrectTotalWhenGivenFullMatchOfStrikes() {
        Frames frames = new Frames(List.of(Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0)));

        int totalScore = scoreCalculator.calculate(frames);

        assertEquals(300,totalScore);

    }

    @Test
    void calculate_shouldReturnCorrectTotalWhenGivenFullMatchIncludingStrikes_SparesAndSimpleFrames() {
        Frames frames = new Frames(List.of(Frame.of(10,0), Frame.of(3,4), Frame.of(5,5), Frame.of(6,4), Frame.of(3,3), Frame.of(2,2), Frame.of(10,0), Frame.of(1,2), Frame.of(3,4), Frame.of(5,4)));

        int totalScore = scoreCalculator.calculate(frames);

        assertEquals(95,totalScore);
    }

    @Test
    void calculate_shouldReturnCorrectTotalWhenGivenFullMatchOfPerfectSpares() {
        Frames frames = new Frames(List.of(Frame.of(9,1),Frame.of(9,1), Frame.of(9,1), Frame.of(9,1), Frame.of(9,1), Frame.of(9,1), Frame.of(9,1), Frame.of(9,1), Frame.of(9,1), Frame.of(9,1), Frame.of(9,0)));

        int totalScore = scoreCalculator.calculate(frames);

        assertEquals(190,totalScore);
    }
    @Test
    void calculateScoreCard_shouldReturnCorrectTotalWhenGivenFullMatchOfSimpleFrames() {
        Frames frames = new Frames(List.of(Frame.of(1, 2), Frame.of(3, 4), Frame.of(5, 4), Frame.of(4, 4), Frame.of(3, 3), Frame.of(2, 2), Frame.of(1, 1), Frame.of(1, 2), Frame.of(3, 4), Frame.of(5, 4)));

        ScoreCard scoreCard = scoreCalculator.calculateScoreCard(frames);

        assertThat(scoreCard.getTotalScore()).isEqualTo(58);

        List<FrameScore> frameScores = scoreCard.getFrameScores();

        assertThat(frameScores.get(0)).isEqualTo(new FrameScore(Frame.of(1,2),3));
        assertThat(frameScores.get(1)).isEqualTo(new FrameScore(Frame.of(3,4),10));
        assertThat(frameScores.get(2)).isEqualTo(new FrameScore(Frame.of(5,4),19));
        assertThat(frameScores.get(3)).isEqualTo(new FrameScore(Frame.of(4,4),27));
        assertThat(frameScores.get(4)).isEqualTo(new FrameScore(Frame.of(3,3),33));
        assertThat(frameScores.get(5)).isEqualTo(new FrameScore(Frame.of(2,2),37));
        assertThat(frameScores.get(6)).isEqualTo(new FrameScore(Frame.of(1,1),39));
        assertThat(frameScores.get(7)).isEqualTo(new FrameScore(Frame.of(1,2),42));
        assertThat(frameScores.get(8)).isEqualTo(new FrameScore(Frame.of(3,4),49));
        assertThat(frameScores.get(9)).isEqualTo(new FrameScore(Frame.of(5,4),58));

    }
    @Test
    void calculateScoreCard_shouldReturnCorrectTotalWhenGivenFullMatchOfFramesIncludingSingleSpare() {
        Frames frames = new Frames(List.of(Frame.of(1, 2), Frame.of(3, 4), Frame.of(5, 5), Frame.of(4, 4), Frame.of(3, 3), Frame.of(2, 2), Frame.of(1, 1), Frame.of(1, 2), Frame.of(3, 4), Frame.of(5, 4)));

        ScoreCard scoreCard = scoreCalculator.calculateScoreCard(frames);

        assertThat(scoreCard.getTotalScore()).isEqualTo(63);

        List<FrameScore> frameScores = scoreCard.getFrameScores();
    }
}