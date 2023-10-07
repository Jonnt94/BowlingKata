package kata.bowling;

import java.util.Objects;

public class FrameScore {
    private final Frame frame;
    private final int score;

    public FrameScore(Frame frame, int score){
        this.frame = frame;
        this.score = score;

    }

    public int getFrameScore(){
        return this.score;
    }


    @Override
    public String toString() {
        return "FrameScore{" +
                "frame=" + frame +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrameScore that = (FrameScore) o;
        return score == that.score && Objects.equals(frame, that.frame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(frame, score);
    }
}
