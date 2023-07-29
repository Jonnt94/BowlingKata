package kata.bowling;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FrameValidatorTest {

//    ToDo: try and come up with other test scenarios. Strikes Spares and length of list. The length of the frame depends on if the was a strike/spare or not.
//    ToDo: Need to check that frames don't add up to more ethan 10.

    @Test
    void returnsTrueWhenFramesListIsLengthOfTenAndTenthFrameIsNeitherStrikeNorSpare() {
        List<Frame> frames = List.of(Frame.of(1,1),Frame.of(1,1),Frame.of(1,1),Frame.of(1,1),Frame.of(1,1),Frame.of(1,1),Frame.of(1,1),Frame.of(1,1),Frame.of(1,1),Frame.of(1,1));

        FrameValidator frameValidator = new FrameValidator();
        boolean valid = frameValidator.validate(frames);

        assertThat(valid).isTrue();
    }
}