package kata.bowling;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScoreBoard {
    private final ScoreValidator scoreValidator;
    private final FrameMapper frameMapper;
    private final ScoreCalculator scoreCalculator;
    public ScoreBoard(ScoreValidator scoreValidator, FrameMapper frameMapper, ScoreCalculator scoreCalculator){
        this.scoreValidator = scoreValidator;
        this.frameMapper = frameMapper;
        this.scoreCalculator = scoreCalculator;
    }

    // Add Frame Validation.
    public int calculateScore(List<Integer> scores) {
        if (scoreValidator.validate(scores)) {
            Frames frames = frameMapper.map(scores);
            return scoreCalculator.calculate(frames);
        }
        return 0;
    }

}
