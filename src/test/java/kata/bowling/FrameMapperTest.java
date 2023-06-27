package kata.bowling;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FrameMapperTest {
    FrameMapper frameMapper = new FrameMapper();

    @Test
    void shouldMapToFrames_whenGivenASimpleListOfScores() {
        List<Integer> scores = List.of(5, 5, 4, 5, 6, 2);

        List<Frame> frames = frameMapper.map(scores);

        assertThat(frames).hasSize(3);
        assertAll(
                () -> assertThat(frames.get(0)).isEqualToComparingFieldByField(Frame.of(5, 5)),
                () -> assertThat(frames.get(1)).isEqualToComparingFieldByField(Frame.of(4, 5)),
                () -> assertThat(frames.get(2)).isEqualToComparingFieldByField(Frame.of(6, 2))
        );
    }
    @Test
    void shouldMapToFrames_whenGivenAListOfScoresContainingAStrike() {
        List<Integer> scores = List.of(5, 5, 10, 6, 2);

        List<Frame> frames = frameMapper.map(scores);

        assertThat(frames).hasSize(3);
        assertAll(
                () -> assertThat(frames.get(0)).isEqualToComparingFieldByField(Frame.of(5, 5)),
                () -> assertThat(frames.get(1)).isEqualToComparingFieldByField(Frame.of(10, 0)),
                () -> assertThat(frames.get(2)).isEqualToComparingFieldByField(Frame.of(6, 2))
        );
    }


}