package kata.bowling;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ScoreValidatorTest {
    @Test
    void shouldReturnFalseWhenGivenListLongerThan20() {
        List<Integer> scores = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1);
        ScoreValidator scoreValidator = new ScoreValidator();

        boolean validationResult = scoreValidator.validate(scores);

        assertFalse(validationResult);
    }

    @Test
    void shouldReturnTrueWhenGivenListOfLength20() {
        List<Integer> scores = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ScoreValidator scoreValidator = new ScoreValidator();

        boolean validationResult = scoreValidator.validate(scores);

        assertTrue(validationResult);
    }

    @Test
    void shouldReturnFalseWhenGivenListLessThan10() {
        List<Integer> scores = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        ScoreValidator scoreValidator = new ScoreValidator();

        boolean validationResult = scoreValidator.validate(scores);

        assertFalse(validationResult);
    }

    @Test
    void shouldReturnTrueWhenGivenListOfLength10() {
        List<Integer> scores = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ScoreValidator scoreValidator = new ScoreValidator();

        boolean validationResult = scoreValidator.validate(scores);

        assertTrue(validationResult);
    }

    @Test
    void shouldReturnFalseWhenNumberEnteredLessThanZero() {
        List<Integer> scores = List.of(1, 2, 3, 4, -5, 6, 7, 8, 9, 10, 10);
        ScoreValidator scoreValidator = new ScoreValidator();

        boolean validationResult = scoreValidator.validate(scores);

        assertFalse(validationResult);
    }

    @Test void shouldReturnFalseWhenGivenSingularNumberGreaterThan10(){
        List<Integer> scores = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        ScoreValidator scoreValidator = new ScoreValidator();

        boolean validationResult = scoreValidator.validate(scores);

        assertFalse(validationResult);
    }
}