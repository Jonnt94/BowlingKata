package kata.bowling;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

import static kata.bowling.StrikeMapper.addSecondAttemptForStrikes;

@Component
public class FrameMapper {
    public List<Frame> map(List<Integer> scores) {
        List<Integer> completeScores = addSecondAttemptForStrikes(scores);
        List<Frame> frames = new ArrayList<>();

        for (int i = 0; i < completeScores.size(); i += 2) {
            Frame frame = Frame.of(completeScores.get(i), completeScores.get(i+1));
            frames.add(frame);
        }

        return frames;
    }
}
