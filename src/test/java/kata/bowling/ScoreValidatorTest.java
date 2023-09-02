package kata.bowling;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ScoreValidatorTest {
    @Test
    void shouldReturnFalseWhenGivenListLongerThan21() {
        List<Integer> scores = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2);
        ScoreValidator scoreValidator = new ScoreValidator();

        boolean validationResult = scoreValidator.validate(scores);

        assertFalse(validationResult);
    }

    @Test
    void shouldReturnTrueWhenGivenListOfLength21() {
        List<Integer> scores = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1);
        ScoreValidator scoreValidator = new ScoreValidator();

        boolean validationResult = scoreValidator.validate(scores);

        assertTrue(validationResult);
    }

    @Test
    void shouldReturnFalseWhenGivenListLessThan12() {
        List<Integer> scores = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1);
        ScoreValidator scoreValidator = new ScoreValidator();

        boolean validationResult = scoreValidator.validate(scores);

        assertFalse(validationResult);
    }

    @Test
    void shouldReturnTrueWhenGivenListOfLength12() {
        List<Integer> scores = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1 ,2);
        ScoreValidator scoreValidator = new ScoreValidator();

        boolean validationResult = scoreValidator.validate(scores);

        assertTrue(validationResult);
    }

    @Test
    void shouldReturnFalseWhenNumberEnteredLessThanZero() {
        List<Integer> scores = List.of(1, 2, 3, 4, -5, 6, 7, 8, 9, 10, 1, 2);
        ScoreValidator scoreValidator = new ScoreValidator();

        boolean validationResult = scoreValidator.validate(scores);

        assertFalse(validationResult);
    }

    @Test void shouldReturnFalseWhenGivenSingularNumberGreaterThan10(){
        List<Integer> scores = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 2);
        ScoreValidator scoreValidator = new ScoreValidator();

        boolean validationResult = scoreValidator.validate(scores);

        assertFalse(validationResult);
    }
}