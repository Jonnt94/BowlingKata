package kata.bowling;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FrameMapper {
    public List<Frame> map(List<Integer> scores) {
        List<Frame> frames = new ArrayList<>();

        for (int i = 0; i < scores.size(); i += 2) {
            Frame frame = new Frame(scores.get(i), scores.get(i+1));
            frames.add(frame);
        }

        return frames;
    }
}
