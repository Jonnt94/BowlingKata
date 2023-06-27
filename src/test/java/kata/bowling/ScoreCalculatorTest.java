package kata.bowling;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoreCalculatorTest {
    ScoreCalculator scoreCalculator = new ScoreCalculator();
    @Test
    void shouldReturnCorrectTotalWhenGivenFullMatchOfSimpleFrames() {
        List<Frame> frames = List.of(Frame.of(1,2), Frame.of(3,4), Frame.of(5,4), Frame.of(4,4), Frame.of(3,3), Frame.of(2,2), Frame.of(1,1), Frame.of(1,2), Frame.of(3,4), Frame.of(5,4));

        int totalScore = scoreCalculator.calculate(frames);

        assertEquals(58,totalScore);
    }

    @Test
    void shouldReturnCorrectTotalWhenGivenFullMatchOfFramesIncludingSingleSpare() {
        List<Frame> frames = List.of(Frame.of(1,2), Frame.of(3,4), Frame.of(5,5), Frame.of(4,4), Frame.of(3,3), Frame.of(2,2), Frame.of(1,1), Frame.of(1,2), Frame.of(3,4), Frame.of(5,4));

        int totalScore = scoreCalculator.calculate(frames);

        assertEquals(63,totalScore);
    }

    @Test
    void shouldReturnCorrectTotalWhenGivenFullMatchOfSpares() {
        List<Frame> frames = List.of(Frame.of(0,10),Frame.of(1,9), Frame.of(2,8), Frame.of(3,7), Frame.of(4,6), Frame.of(5,5), Frame.of(6,4), Frame.of(7,3), Frame.of(8,2), Frame.of(9,1));

        int totalScore = scoreCalculator.calculate(frames);

        assertEquals(145,totalScore);
    }

    @Test
    void shouldReturnCorrectTotalWhenGivenFullMatchOfFramesIncludingSingleStrike(){
        List<Frame> frames = List.of(Frame.of(1,2), Frame.of(3,4), Frame.of(5,4), Frame.of(4,4), Frame.of(3,3), Frame.of(2,2), Frame.of(10, 0), Frame.of(1,2), Frame.of(3,4), Frame.of(5,4));

        int totalScore = scoreCalculator.calculate(frames);

        assertEquals(69,totalScore);
    }

    @Test
    void shouldReturnCorrectTotalWhenGivenFullMatchOfStrikes() {
        List<Frame> frames = List.of(Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0), Frame.of(10,0));

        int totalScore = scoreCalculator.calculate(frames);

        assertEquals(270,totalScore);

    }

    @Test
    void shouldReturnCorrectTotalWhenGivenFullMatchIncludingStrikes_SparesAndSimpleFrames() {
        List<Frame> frames = List.of(Frame.of(10,0), Frame.of(3,4), Frame.of(5,5), Frame.of(6,4), Frame.of(3,3), Frame.of(2,2), Frame.of(10,0), Frame.of(1,2), Frame.of(3,4), Frame.of(5,4));

        int totalScore = scoreCalculator.calculate(frames);

        assertEquals(95,totalScore);
    }
}