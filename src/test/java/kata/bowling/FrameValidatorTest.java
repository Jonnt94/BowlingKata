package kata.bowling;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FrameValidatorTest {
    private static final List<Frame> NINE_STANDARD_FRAMES = List.of(Frame.of(1,1),Frame.of(1,1),Frame.of(1,1),Frame.of(1,1),Frame.of(1,1),Frame.of(1,1),Frame.of(1,1),Frame.of(1,1),Frame.of(1,1));

    @Test
    void returnsTrueWhenFramesListIsLengthOfTenAndTenthFrameIsNeitherStrikeNorSpare() {
        List<Frame> frames = append(NINE_STANDARD_FRAMES,Frame.of(1,1));

        FrameValidator frameValidator = new FrameValidator();
        boolean valid = frameValidator.validate(frames);

        assertThat(valid).isTrue();
    }

    @Test
    void returnsFalseWhenFramesListLengthIsLessThanTen(){

        FrameValidator frameValidator = new FrameValidator();
        boolean valid = frameValidator.validate(NINE_STANDARD_FRAMES);

        assertThat(valid).isFalse();
    }

    @Test
    void returnsTrueWhenFramesListIsLengthOfElevenIfTenthFrameIsStrike() {
        List<Frame> frames = append(NINE_STANDARD_FRAMES,Frame.of(10,0),Frame.of(1,1));

        FrameValidator frameValidator = new FrameValidator();
        boolean valid = frameValidator.validate(frames);

        assertThat(valid).isTrue();
    }

    @Test
    void returnsTrueWhenFramesListIsLengthOfTwelfthIfTenthAndEleventhFramesAreBothStrikes() {
        List<Frame> frames = append(NINE_STANDARD_FRAMES,Frame.of(10,0),Frame.of(10,0),Frame.of(1,0));

        FrameValidator frameValidator = new FrameValidator();
        boolean valid = frameValidator.validate(frames);

        assertThat(valid).isTrue();
    }

    @Test
    void returnsTrueWhenFramesListIsLengthOfElevenIfTenthFramesIsASpare(){
        List<Frame> frames = append(NINE_STANDARD_FRAMES,Frame.of(5,5),Frame.of(1,0));

        FrameValidator frameValidator = new FrameValidator();
        boolean valid = frameValidator.validate(frames);

        assertThat(valid).isTrue();
    }

    @Test
    void returnsFalseWhenFramesAddUpToMoreThanTen(){
        List<Frame> frames = append(NINE_STANDARD_FRAMES,Frame.of(6,6));

        FrameValidator frameValidator = new FrameValidator();
        boolean valid = frameValidator.validate(frames);

        assertThat(valid).isFalse();
    }

    @Test
    void returnsFalseIfEleventhFrameHasTwoAttemptsWhenTenthFrameIsSpare(){
        List<Frame> frames = append(NINE_STANDARD_FRAMES,Frame.of(5,5),Frame.of(1,1));

        FrameValidator frameValidator = new FrameValidator();
        boolean valid = frameValidator.validate(frames);

        assertThat(valid).isFalse();
    }

    @Test
    void returnsFalseWhenTwelfthFrameHasTwoAttemptsWhenTenthAndEleventhFramesAreBothStrikes(){
        List<Frame> frames = append(NINE_STANDARD_FRAMES,Frame.of(10,0),Frame.of(10,0),Frame.of(1,1));

        FrameValidator frameValidator = new FrameValidator();
        boolean valid = frameValidator.validate(frames);

        assertThat(valid).isFalse();
    }

    @Test
    void returnsFalseWhenTenthFrameIsStrikeAndNoAdditionalFrames(){
        List<Frame> frames = append(NINE_STANDARD_FRAMES,Frame.of(10,0));

        FrameValidator frameValidator = new FrameValidator();
        boolean valid = frameValidator.validate(frames);

        assertThat(valid).isFalse();
    }

    @Test
    void returnsFalseWhenTenthFrameIsSpareAndNoAdditionalFrames(){
        List<Frame> frames = append(NINE_STANDARD_FRAMES,Frame.of(5,5));

        FrameValidator frameValidator = new FrameValidator();
        boolean valid = frameValidator.validate(frames);

        assertThat(valid).isFalse();
    }

    private List<Frame> append(List<Frame> list, Frame... element){
       return Stream.concat(list.stream(),Stream.of(element)).toList();
    }

}
