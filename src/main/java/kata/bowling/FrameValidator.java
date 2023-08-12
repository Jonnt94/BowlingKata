package kata.bowling;

public class FrameValidator {
    public boolean validate(Frames frames){

        if (frames.numberOfFrames() < 10 || frames.numberOfFrames() > 13){
            return false;
        }

        if (hasAnyFrameScoreGreaterThan10(frames)) return false;

        if (frames.getFrameAtPosition(10).isStrike()){
            if(frames.numberOfFrames() == 10){
                return false;
            }
            if(frames.numberOfFrames() == 11){
                return true;
            }
            if (frames.numberOfFrames() == 12){
                if(frames.getFrameAtPosition(11).isStrike()){
                    if(frames.getFrameAtPosition(12).pinsKnockedDownAttempt2() == 0){
                        return true;
                    }
                }
            }
        }

        if (frames.getFrameAtPosition(10).isSpare()){
            if(frames.numberOfFrames() == 10){
                return false;
            }
            if (frames.numberOfFrames() == 11){
                if (frames.getFrameAtPosition(11).pinsKnockedDownAttempt2() == 0){
                    return true;
                }
            }
        }
        if (frames.numberOfFrames() == 10){
            return true;
        }

        return false;
    }

    private static boolean hasAnyFrameScoreGreaterThan10(Frames frames) {
        for (Frame frame : frames.asList()){
            if(frame.totalPinsKnockedDown() > 10){
                return true;
            }
        }
        return false;
    }
}
