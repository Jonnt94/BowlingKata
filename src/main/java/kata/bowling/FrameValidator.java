package kata.bowling;

import java.util.List;

public class FrameValidator {
    public boolean validate(List<Frame> frames){

        if (frames.size() < 10 || frames.size() > 13){
            return false;
        }

        if (hasAnyFrameScoreGreaterThan10(frames)) return false;

        if (frames.get(9).isStrike()){
            if(frames.size() == 10){
                return false;
            }
            if(frames.size() == 11){
                return true;
            }
            if (frames.size() == 12){
                if(frames.get(10).isStrike()){
                    if(frames.get(11).pinsKnockedDownAttempt2() == 0){
                        return true;
                    }
                }
            }
        }

        if (frames.get(9).isSpare()){
            if(frames.size() == 10){
                return false;
            }
            if (frames.size() == 11){
                if (frames.get(10).pinsKnockedDownAttempt2() == 0){
                    return true;
                }
            }
        }
        if (frames.size() == 10){
            return true;
        }

        return false;
    }

    private static boolean hasAnyFrameScoreGreaterThan10(List<Frame> frames) {
        for (Frame frame : frames){
            if(frame.totalPinsKnockedDown() > 10){
                return true;
            }
        }
        return false;
    }
}
