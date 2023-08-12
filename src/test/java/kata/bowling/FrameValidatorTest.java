package kata.bowling;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FrameValidatorTest {
    private static final Frames NINE_STANDARD_FRAMES = new Frames(List.of(Frame.of(1,1),Frame.of(1,1),Frame.of(1,1),Frame.of(1,1),Frame.of(1,1),Frame.of(1,1),Frame.of(1,1),Frame.of(1,1),Frame.of(1,1)));

    @Test
    void returnsTrueWhenFramesListIsLengthOfTenAndTenthFrameIsNeitherStrikeNorSpare() {
        Frames frames = NINE_STANDARD_FRAMES.append(Frame.of(1,1));

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
        Frames frames = NINE_STANDARD_FRAMES.append(Frame.of(10,0)).append(Frame.of(1,1));

        FrameValidator frameValidator = new FrameValidator();
        boolean valid = frameValidator.validate(frames);

        assertThat(valid).isTrue();
    }

    @Test
    void returnsTrueWhenFramesListIsLengthOfTwelfthIfTenthAndEleventhFramesAreBothStrikes() {
        Frames frames = NINE_STANDARD_FRAMES.append(Frame.of(10,0)).append(Frame.of(10,0)).append(Frame.of(1,0));

        FrameValidator frameValidator = new FrameValidator();
        boolean valid = frameValidator.validate(frames);

        assertThat(valid).isTrue();
    }

    @Test
    void returnsTrueWhenFramesListIsLengthOfElevenIfTenthFramesIsASpare(){
        Frames frames = NINE_STANDARD_FRAMES.append(Frame.of(5,5)).append(Frame.of(1,0));

        FrameValidator frameValidator = new FrameValidator();
        boolean valid = frameValidator.validate(frames);

        assertThat(valid).isTrue();
    }

    @Test
    void returnsFalseWhenFramesAddUpToMoreThanTen(){
        Frames frames = NINE_STANDARD_FRAMES.append(Frame.of(6,6));

        FrameValidator frameValidator = new FrameValidator();
        boolean valid = frameValidator.validate(frames);

        assertThat(valid).isFalse();
    }

    @Test
    void returnsFalseIfEleventhFrameHasTwoAttemptsWhenTenthFrameIsSpare(){
        Frames frames = NINE_STANDARD_FRAMES.append(Frame.of(5,5)).append(Frame.of(1,1));

        FrameValidator frameValidator = new FrameValidator();
        boolean valid = frameValidator.validate(frames);

        assertThat(valid).isFalse();
    }

    @Test
    void returnsFalseWhenTwelfthFrameHasTwoAttemptsWhenTenthAndEleventhFramesAreBothStrikes(){
        Frames frames = NINE_STANDARD_FRAMES.append(Frame.of(10,0)).append(Frame.of(10,0)).append(Frame.of(1,1));

        FrameValidator frameValidator = new FrameValidator();
        boolean valid = frameValidator.validate(frames);

        assertThat(valid).isFalse();
    }

    @Test
    void returnsFalseWhenTenthFrameIsStrikeAndNoAdditionalFrames(){
        Frames frames = NINE_STANDARD_FRAMES.append(Frame.of(10,0));

        FrameValidator frameValidator = new FrameValidator();
        boolean valid = frameValidator.validate(frames);

        assertThat(valid).isFalse();
    }
    @Test
    void returnsFalseWhenTenthFrameIsStrikeAndEleventhFrameIsAStrikeButTwelfthFrame(){
        Frames frames = NINE_STANDARD_FRAMES.append(Frame.of(10,0)).append(Frame.of(10,0));

        FrameValidator frameValidator = new FrameValidator();
        boolean valid = frameValidator.validate(frames);

        assertThat(valid).isFalse();
    }

    @Test
    void returnsFalseWhenTenthFrameIsSpareAndNoAdditionalFrames(){
        Frames frames = NINE_STANDARD_FRAMES.append(Frame.of(5,5));

        FrameValidator frameValidator = new FrameValidator();
        boolean valid = frameValidator.validate(frames);

        assertThat(valid).isFalse();
    }


}
