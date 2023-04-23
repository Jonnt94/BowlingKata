package kata.bowling;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoreBoardTest {
    @Test
    void shouldCalculateAndReturnScore35() {
        List<Integer> scores = List.of(10, 10, 10, 5);

        ScoreBoard scoreBoard = new ScoreBoard();
        int totalScore = scoreBoard.calculateScore(scores);

        assertEquals(35, totalScore);
    }
    @Test
    void shouldCalculateAndReturnScore40() {
        List<Integer> scores = List.of(10, 10, 10, 10);

        ScoreBoard scoreBoard = new ScoreBoard();
        int totalScore = scoreBoard.calculateScore(scores);

        assertEquals(40, totalScore);
    }
}