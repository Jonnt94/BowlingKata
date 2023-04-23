package kata.bowling;

import kata.ScoreValidator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScoreValidatorTest {
    @Test
    void shouldReturnFalseWhenGivenListLongerThan20(){
        List<Integer> scores = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21);
        ScoreValidator scoreValidator = new ScoreValidator();

        boolean validationResult = scoreValidator.validate(scores);

        assertFalse(validationResult);
    }
    @Test
    void shouldReturnTrueWhenGivenListOfLength20(){
        List<Integer> scores = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
        ScoreValidator scoreValidator = new ScoreValidator();

        boolean validationResult = scoreValidator.validate(scores);

        assertTrue(validationResult);
    }
}
