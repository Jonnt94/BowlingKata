package kata.bowling;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScoreBoard {
    private final ScoreValidator scoreValidator;
    private final FrameMapper frameMapper;
    private final FrameValidator frameValidator;
    private final ScoreCalculator scoreCalculator;
    public ScoreBoard(ScoreValidator scoreValidator,
                      FrameMapper frameMapper,
                      FrameValidator frameValidator,
                      ScoreCalculator scoreCalculator){
        this.scoreValidator = scoreValidator;
        this.frameMapper = frameMapper;
        this.frameValidator = frameValidator;
        this.scoreCalculator = scoreCalculator;
    }


    public int calculateScore(List<Integer> scores) {
        if (scoreValidator.validate(scores)) {
            Frames frames = frameMapper.map(scores);
            if (frameValidator.validate(frames)) {
                return scoreCalculator.calculate(frames);
            }
        }
        return 0;
    }

}
