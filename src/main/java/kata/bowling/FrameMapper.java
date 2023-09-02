package kata.bowling;

import org.springframework.stereotype.Component;

import java.util.List;

import static kata.bowling.StrikeMapper.addSecondAttemptForStrikes;

@Component
public class FrameMapper {
    public Frames map(List<Integer> scores) {
        List<Integer> completeScores = addSecondAttemptForStrikes(scores);
        Frames frames = new Frames();

        for (int i = 0; i < completeScores.size(); i += 2) {
            Integer attempt1 = completeScores.get(i);
            Integer attempt2;

            if(completeScores.size() == (i+1)) {
                attempt2 = 0;
            }else {
                attempt2 = completeScores.get(i + 1);
            }

            Frame frame = Frame.of(attempt1, attempt2);
            frames = frames.append(frame);
        }

        return frames;
    }
}
