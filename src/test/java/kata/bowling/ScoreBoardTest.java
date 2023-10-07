package kata.bowling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static kata.bowling.ScoreCard.ScoreCardBuilder.aScoreCard;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
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
    @MockBean
    private FrameValidator frameValidator;
    @Test
    void calculateScore_shouldCalculateAndReturnScore() {
        List<Integer> scores = List.of(1, 2, 3, 4, 5, 6);
        Frames frames = new Frames(List.of(Frame.of(1, 2)));

        when(scoreValidator.validate(any())).thenReturn(true);
        when(frameMapper.map(any())).thenReturn(frames);
        when(frameValidator.validate(any())).thenReturn(true);
        when(scoreCalculator.calculate(any())).thenReturn(21);

        int totalScore = scoreBoard.calculateScore(scores);

        verify(scoreValidator).validate(scores);
        verify(frameMapper).map(scores);
        verify(frameValidator).validate(frames);
        verify(scoreCalculator).calculate(frames);
        assertEquals(21, totalScore);
    }
    @Test
    void calculateScore_shouldReturn0WhenScoresNotValid() {
        when(scoreValidator.validate(any())).thenReturn(false);
        List<Integer> scores = List.of(10, 10, 10, 10);

        int totalScore = scoreBoard.calculateScore(scores);

        verify(scoreValidator).validate(scores);
        assertEquals(0, totalScore);

        verify(frameMapper, never()).map(any());
        verify(frameValidator, never()).validate(any());
        verify(scoreCalculator, never()).calculate(any());
    }

    @Test
    void calculateScore_shouldReturn0WhenFramesNotValid() {
        List<Integer> scores = List.of(1, 2, 3, 4, 5, 6);
        Frames frames = new Frames(List.of(Frame.of(1, 2)));

        when(scoreValidator.validate(any())).thenReturn(true);
        when(frameMapper.map(any())).thenReturn(frames);
        when(frameValidator.validate(any())).thenReturn(false);
        when(scoreCalculator.calculate(any())).thenReturn(21);

        int totalScore = scoreBoard.calculateScore(scores);

        verify(scoreValidator).validate(scores);
        verify(frameMapper).map(scores);
        verify(frameValidator).validate(frames);
        verify(scoreCalculator, never()).calculate(any());
        assertEquals(0, totalScore);
    }

    @Test
    void calculateDetailedScore_shouldCalculateAndReturnScore() {
        List<Integer> scores = List.of(1, 2, 3, 4, 5, 6);
        Frames frames = new Frames(List.of(Frame.of(1, 2)));
        ScoreCard scoreCard = aScoreCard().build();

        when(scoreValidator.validate(any())).thenReturn(true);
        when(frameMapper.map(any())).thenReturn(frames);
        when(frameValidator.validate(any())).thenReturn(true);
        when(scoreCalculator.calculateScoreCard(any())).thenReturn(scoreCard);

        ScoreCard returnedScoreCard = scoreBoard.calculateDetailedScores(scores);

        verify(scoreValidator).validate(scores);
        verify(frameMapper).map(scores);
        verify(frameValidator).validate(frames);
        verify(scoreCalculator).calculateScoreCard(frames);
        assertThat(returnedScoreCard).isSameAs(scoreCard);
    }
    @Test
    void calculateDetailedScore_shouldReturn0WhenScoresNotValid() {
        when(scoreValidator.validate(any())).thenReturn(false);
        List<Integer> scores = List.of(10, 10, 10, 10);

        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(()->scoreBoard.calculateDetailedScores(scores))
                .withMessage("Scores not valid!");

        verify(scoreValidator).validate(scores);
        verify(frameMapper, never()).map(any());
        verify(frameValidator, never()).validate(any());
        verify(scoreCalculator, never()).calculateScoreCard(any());
    }

    @Test
    void calculateDetailedScore_shouldReturn0WhenFramesNotValid() {
        List<Integer> scores = List.of(1, 2, 3, 4, 5, 6);
        Frames frames = new Frames(List.of(Frame.of(1, 2)));

        when(scoreValidator.validate(any())).thenReturn(true);
        when(frameMapper.map(any())).thenReturn(frames);
        when(frameValidator.validate(any())).thenReturn(false);

        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(()->scoreBoard.calculateDetailedScores(scores))
                .withMessage("Frames not valid!");

        verify(scoreValidator).validate(scores);
        verify(frameMapper).map(scores);
        verify(frameValidator).validate(frames);
        verify(scoreCalculator, never()).calculateScoreCard(any());
    }
}