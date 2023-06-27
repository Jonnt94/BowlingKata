package kata.bowling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ScoreBoard.class})
class ScoreBoardTest {

    @Autowired
    private ScoreBoard scoreBoard;
    @MockBean
    private ScoreValidator scoreValidator;
    @MockBean
    private FrameMapper frameMapper;
    @MockBean
    private ScoreCalculator scoreCalculator;
    @Test
    void shouldCalculateAndReturnScore16() {
        List<Integer> scores = List.of(1, 2, 3, 4, 5, 6);
        List<Frame> frames = List.of(Frame.of(1, 2));

        when(scoreValidator.validate(any())).thenReturn(true);
        when(frameMapper.map(any())).thenReturn(frames);
        when(scoreCalculator.calculate(any())).thenReturn(21);

        int totalScore = scoreBoard.calculateScore(scores);

        verify(scoreValidator).validate(scores);
        verify(frameMapper).map(scores);
        verify(scoreCalculator).calculate(frames);
        assertEquals(21, totalScore);
    }
    @Test
    void shouldReturn0WhenScoresNotValid() {
        when(scoreValidator.validate(any())).thenReturn(false);
        List<Integer> scores = List.of(10, 10, 10, 10);

        int totalScore = scoreBoard.calculateScore(scores);

        verify(scoreValidator).validate(scores);
        assertEquals(0, totalScore);

        verify(frameMapper, never()).map(any());
    }

}