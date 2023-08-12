package kata.bowling;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreCalculatorTest {
    ScoreCalculator scoreCalculator = new ScoreCalculator();
    @Test
    void shouldReturnCorrectTotalWhenGivenFullMatchOfSimpleFrames() {
        Frames frames = new Frames(List.of(Frame.of(1,2), Frame.of(3,4), Frame.of(5,4), Frame.of(4,4), Frame.of(3,3), Frame.of(2,2), Frame.of(1,1), Frame.of(1,2), Frame.of(3,4), Frame.of(5,4)));

        int totalScore = scoreCalculator.calculate(frames);

        assertEquals(58,totalScore);
    }

    @Test
    void shouldReturnCorrectTotalWhenGivenFullMatchOfFramesIncludingSingleSpare() {
        Frames frames = new Frames(List.of(Frame.of(1,2), Frame.of(3,4), Frame.of(5,5), Frame.of(4,4), Frame.of(3,3), Frame.of(2,2), Frame.of(1,1), Frame.of(1,2), Frame.of(3,4), Frame.of(5,4)));

        int totalScore = scoreCalculator.calculate(frames);

        assertEquals(63,totalScore);
    }

    @Test
    void shouldReturnCorrectTotalWhenGivenFullMatchOfSpares() {
        Frames frames = new Frames(List.of(Frame.of(0,10),Frame.of(1,9), Frame.of(2,8), Frame.of(3,7), Frame.of(4,6), Frame.of(5,5), Frame.of(6,4), Frame.of(7,3), Frame.of(8,2), Frame.of(9,1), Frame.of(9,0)));

        int totalScore = scoreCalculator.calculate(frames);

        assertEquals(154,totalScore);
    }

    @Test
    void shouldReturnCorrectTotalWhenGivenFullMatchOfFramesIncludingSingleStrike(){
        Frames frames = new Frames(List.of(Frame.of(1,2), Frame.of(3,4), Frame.of(5,4), Frame.of(4,4), Frame.of(3,3), Frame.of(2,2), Frame.of(10, 0), Frame.of(1,2), Frame.of(3,4), Frame.of(5,4)));

        int totalScore = scoreCalculator.calculate(frames);

        assertEquals(69,totalScore);
    }

    @Test
    void shouldReturnCorrectTotalWhenGivenFullMatchOfStrikes() {
        Frames frames = new Frames(List.of(Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0)));

        int totalScore = scoreCalculator.calculate(frames);

        assertEquals(300,totalScore);

    }

    @Test
    void shouldReturnCorrectTotalWhenGivenFullMatchIncludingStrikes_SparesAndSimpleFrames() {
        Frames frames = new Frames(List.of(Frame.of(10,0), Frame.of(3,4), Frame.of(5,5), Frame.of(6,4), Frame.of(3,3), Frame.of(2,2), Frame.of(10,0), Frame.of(1,2), Frame.of(3,4), Frame.of(5,4)));

        int totalScore = scoreCalculator.calculate(frames);

        assertEquals(95,totalScore);
    }

    @Test
    void shouldReturnCorrectTotalWhenGivenFullMatchOfPerfectSpares() {
        Frames frames = new Frames(List.of(Frame.of(9,1),Frame.of(9,1), Frame.of(9,1), Frame.of(9,1), Frame.of(9,1), Frame.of(9,1), Frame.of(9,1), Frame.of(9,1), Frame.of(9,1), Frame.of(9,1), Frame.of(9,0)));

        int totalScore = scoreCalculator.calculate(frames);

        assertEquals(190,totalScore);
    }
}