package kata.bowling;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScoreBoard {
    private final ScoreValidator scoreValidator;
    private final FrameMapper frameMapper;
    public ScoreBoard(ScoreValidator scoreValidator, FrameMapper frameMapper){
        this.scoreValidator = scoreValidator;
        this.frameMapper = frameMapper;}

    public int calculateScore(List<Integer> scores) {
        if (scoreValidator.validate(scores)) {
            List<Frame> frames = frameMapper.map(scores);
            int runningTotal = 0;
            for (Frame frame : frames) {
                runningTotal += frame.calculateScore();
            }
            return runningTotal;
        }
        return 0;
    }

}
