package kata.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ScoreBoard.class})
class ScoreBoardTest {

    @Autowired
    private ScoreBoard scoreBoard;
    @MockBean
    private ScoreValidator scoreValidator;
    @Test
    void shouldCalculateAndReturnScore35() {
        when(scoreValidator.validate(any())).thenReturn(true);
        List<Integer> scores = List.of(10, 10, 10, 5);

        int totalScore = scoreBoard.calculateScore(scores);

        verify(scoreValidator).validate(scores);
        assertEquals(35, totalScore);
    }
    @Test
    void shouldCalculateAndReturnScore40() {
        when(scoreValidator.validate(any())).thenReturn(true);
        List<Integer> scores = List.of(10, 10, 10, 10);

        int totalScore = scoreBoard.calculateScore(scores);

        verify(scoreValidator).validate(scores);
        assertEquals(40, totalScore);
    }
    @Test
    void shouldReturn0WhenScoresNotValid() {
        when(scoreValidator.validate(any())).thenReturn(false);
        List<Integer> scores = List.of(10, 10, 10, 10);

        int totalScore = scoreBoard.calculateScore(scores);

        verify(scoreValidator).validate(scores);
        assertEquals(0, totalScore);
    }
}