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

        assertThat(frameScores.get(0)).isEqualTo(new FrameScore(Frame.of(1,2),3));
        assertThat(frameScores.get(1)).isEqualTo(new FrameScore(Frame.of(3,4),10));
        assertThat(frameScores.get(2)).isEqualTo(new FrameScore(Frame.of(5,5),24));
        assertThat(frameScores.get(3)).isEqualTo(new FrameScore(Frame.of(4,4),32));
        assertThat(frameScores.get(4)).isEqualTo(new FrameScore(Frame.of(3,3),38));
        assertThat(frameScores.get(5)).isEqualTo(new FrameScore(Frame.of(2,2),42));
        assertThat(frameScores.get(6)).isEqualTo(new FrameScore(Frame.of(1,1),44));
        assertThat(frameScores.get(7)).isEqualTo(new FrameScore(Frame.of(1,2),47));
        assertThat(frameScores.get(8)).isEqualTo(new FrameScore(Frame.of(3,4),54));
        assertThat(frameScores.get(9)).isEqualTo(new FrameScore(Frame.of(5,4),63));
    }
    @Test
    void calculateScoreCard_shouldReturnCorrectTotalWhenGivenFullMatchOfSpares() {
        Frames frames = new Frames(List.of(Frame.of(0,10),Frame.of(1,9), Frame.of(2,8), Frame.of(3,7), Frame.of(4,6), Frame.of(5,5), Frame.of(6,4), Frame.of(7,3), Frame.of(8,2), Frame.of(9,1), Frame.of(9,0)));

        ScoreCard scoreCard = scoreCalculator.calculateScoreCard(frames);

        assertThat(scoreCard.getTotalScore()).isEqualTo(163);

        List<FrameScore> frameScores = scoreCard.getFrameScores();

        assertThat(frameScores.get(0)).isEqualTo(new FrameScore(Frame.of(0,10),11));
        assertThat(frameScores.get(1)).isEqualTo(new FrameScore(Frame.of(1,9),23));
        assertThat(frameScores.get(2)).isEqualTo(new FrameScore(Frame.of(2,8),36));
        assertThat(frameScores.get(3)).isEqualTo(new FrameScore(Frame.of(3,7),50));
        assertThat(frameScores.get(4)).isEqualTo(new FrameScore(Frame.of(4,6),65));
        assertThat(frameScores.get(5)).isEqualTo(new FrameScore(Frame.of(5,5),81));
        assertThat(frameScores.get(6)).isEqualTo(new FrameScore(Frame.of(6,4),98));
        assertThat(frameScores.get(7)).isEqualTo(new FrameScore(Frame.of(7,3),116));
        assertThat(frameScores.get(8)).isEqualTo(new FrameScore(Frame.of(8,2),135));
        assertThat(frameScores.get(9)).isEqualTo(new FrameScore(Frame.of(9,1),154));
        assertThat(frameScores.get(10)).isEqualTo(new FrameScore(Frame.of(9,0),163));
    }

    @Test
    void calculateScoreCard_shouldReturnCorrectTotalWhenGivenFullMatchOfFramesIncludingSingleStrike(){
        Frames frames = new Frames(List.of(Frame.of(1,2), Frame.of(3,4), Frame.of(5,4), Frame.of(4,4), Frame.of(3,3), Frame.of(2,2), Frame.of(10, 0), Frame.of(1,2), Frame.of(3,4), Frame.of(5,4)));

        ScoreCard scoreCard = scoreCalculator.calculateScoreCard(frames);

        assertThat(scoreCard.getTotalScore()).isEqualTo(69);

        List<FrameScore> frameScores = scoreCard.getFrameScores();

        assertThat(frameScores.get(0)).isEqualTo(new FrameScore(Frame.of(1,2),3));
        assertThat(frameScores.get(1)).isEqualTo(new FrameScore(Frame.of(3,4),10));
        assertThat(frameScores.get(2)).isEqualTo(new FrameScore(Frame.of(5,4),19));
        assertThat(frameScores.get(3)).isEqualTo(new FrameScore(Frame.of(4,4),27));
        assertThat(frameScores.get(4)).isEqualTo(new FrameScore(Frame.of(3,3),33));
        assertThat(frameScores.get(5)).isEqualTo(new FrameScore(Frame.of(2,2),37));
        assertThat(frameScores.get(6)).isEqualTo(new FrameScore(Frame.of(10,0),50));
        assertThat(frameScores.get(7)).isEqualTo(new FrameScore(Frame.of(1,2),53));
        assertThat(frameScores.get(8)).isEqualTo(new FrameScore(Frame.of(3,4),60));
        assertThat(frameScores.get(9)).isEqualTo(new FrameScore(Frame.of(5,4),69));
    }
    @Test
    void calculateScoreCard_shouldReturnCorrectTotalWhenGivenFullMatchOfStrikes() {
        Frames frames = new Frames(List.of(Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0)));

        ScoreCard scoreCard = scoreCalculator.calculateScoreCard(frames);

        assertThat(scoreCard.getTotalScore()).isEqualTo(300);

        List<FrameScore> frameScores = scoreCard.getFrameScores();

        assertThat(frameScores.get(0)).isEqualTo(new FrameScore(Frame.of(10,0),30));
        assertThat(frameScores.get(1)).isEqualTo(new FrameScore(Frame.of(10,0),60));
        assertThat(frameScores.get(2)).isEqualTo(new FrameScore(Frame.of(10,0),90));
        assertThat(frameScores.get(3)).isEqualTo(new FrameScore(Frame.of(10,0),120));
        assertThat(frameScores.get(4)).isEqualTo(new FrameScore(Frame.of(10,0),150));
        assertThat(frameScores.get(5)).isEqualTo(new FrameScore(Frame.of(10,0),180));
        assertThat(frameScores.get(6)).isEqualTo(new FrameScore(Frame.of(10,0),210));
        assertThat(frameScores.get(7)).isEqualTo(new FrameScore(Frame.of(10,0),240));
        assertThat(frameScores.get(8)).isEqualTo(new FrameScore(Frame.of(10,0),270));
        assertThat(frameScores.get(9)).isEqualTo(new FrameScore(Frame.of(10,0),300));
        assertThat(frameScores.get(10)).isEqualTo(new FrameScore(Frame.of(10,0),320));
        assertThat(frameScores.get(11)).isEqualTo(new FrameScore(Frame.of(10,0),330));

    }

    @Test
    void calculateScoreCard_shouldReturnCorrectTotalWhenGivenFullMatchIncludingStrikes_SparesAndSimpleFrames() {
        Frames frames = new Frames(List.of(Frame.of(10,0), Frame.of(3,4), Frame.of(5,5), Frame.of(6,4), Frame.of(3,3), Frame.of(2,2), Frame.of(10,0), Frame.of(1,2), Frame.of(3,4), Frame.of(5,4)));

        ScoreCard scoreCard = scoreCalculator.calculateScoreCard(frames);

        assertThat(scoreCard.getTotalScore()).isEqualTo(95);

        List<FrameScore> frameScores = scoreCard.getFrameScores();

        assertThat(frameScores.get(0)).isEqualTo(new FrameScore(Frame.of(10,0),17));
        assertThat(frameScores.get(1)).isEqualTo(new FrameScore(Frame.of(3,4),24));
        assertThat(frameScores.get(2)).isEqualTo(new FrameScore(Frame.of(5,5),40));
        assertThat(frameScores.get(3)).isEqualTo(new FrameScore(Frame.of(6,4),53));
        assertThat(frameScores.get(4)).isEqualTo(new FrameScore(Frame.of(3,3),59));
        assertThat(frameScores.get(5)).isEqualTo(new FrameScore(Frame.of(2,2),63));
        assertThat(frameScores.get(6)).isEqualTo(new FrameScore(Frame.of(10,0),76));
        assertThat(frameScores.get(7)).isEqualTo(new FrameScore(Frame.of(1,2),79));
        assertThat(frameScores.get(8)).isEqualTo(new FrameScore(Frame.of(3,4),86));
        assertThat(frameScores.get(9)).isEqualTo(new FrameScore(Frame.of(5,4),95));
    }
    @Test
    void calculateScoreCard_shouldReturnCorrectTotalWhenGivenFullMatchOfPerfectSpares() {
        Frames frames = new Frames(List.of(Frame.of(9,1),Frame.of(9,1), Frame.of(9,1), Frame.of(9,1), Frame.of(9,1), Frame.of(9,1), Frame.of(9,1), Frame.of(9,1), Frame.of(9,1), Frame.of(9,1), Frame.of(9,0)));

        ScoreCard scoreCard = scoreCalculator.calculateScoreCard(frames);

        assertThat(scoreCard.getTotalScore()).isEqualTo(199);

        List<FrameScore> frameScores = scoreCard.getFrameScores();

        assertThat(frameScores.get(0)).isEqualTo(new FrameScore(Frame.of(9,1),19));
        assertThat(frameScores.get(1)).isEqualTo(new FrameScore(Frame.of(9,1),38));
        assertThat(frameScores.get(2)).isEqualTo(new FrameScore(Frame.of(9,1),57));
        assertThat(frameScores.get(3)).isEqualTo(new FrameScore(Frame.of(9,1),76));
        assertThat(frameScores.get(4)).isEqualTo(new FrameScore(Frame.of(9,1),95));
        assertThat(frameScores.get(5)).isEqualTo(new FrameScore(Frame.of(9,1),114));
        assertThat(frameScores.get(6)).isEqualTo(new FrameScore(Frame.of(9,1),133));
        assertThat(frameScores.get(7)).isEqualTo(new FrameScore(Frame.of(9,1),152));
        assertThat(frameScores.get(8)).isEqualTo(new FrameScore(Frame.of(9,1),171));
        assertThat(frameScores.get(9)).isEqualTo(new FrameScore(Frame.of(9,1),190));
        assertThat(frameScores.get(10)).isEqualTo(new FrameScore(Frame.of(9,0),199));
    }
}