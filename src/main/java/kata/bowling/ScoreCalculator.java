package kata.bowling;

public class ScoreCalculator {
// refactor this to use private methods.
    public int calculate(Frames frames) {
        int runningTotal = 0;
        for (int i = 1; i <= 10; i++) {
            Frame frame = frames.getFrameAtPosition(i);
            int totalPinsKnockedDownInFrame = frame.totalPinsKnockedDown();
            runningTotal += totalPinsKnockedDownInFrame;
            if (frame.isStrikeOrSpare()) {
                runningTotal += getBonusScore(frames, frame, i);
            }
        }
        return runningTotal;
    }

    private int getBonusScore(Frames frames, Frame currentFrame, int i){
        Frame nextFrame = frames.getFrameAtPosition(i + 1);
        int bonusScore;
        if (currentFrame.isStrike()) {
            Frame nextNextFrame = frames.getFrameAtPosition(i + 2);
            bonusScore = getBonusStrikeScore(nextFrame, nextNextFrame);
        } else {
            bonusScore = getBonusSpareScore(nextFrame);
        }
        return bonusScore;
    }

    private int getBonusSpareScore(Frame nextFrame) {
        return nextFrame.pinsKnockedDownAttempt1();

    }

    private int getBonusStrikeScore(Frame nextFrame, Frame nextNextFrame) {
        int attempt1BonusPins = nextFrame.pinsKnockedDownAttempt1();
        int attempt2BonusPins;
        if(attempt1BonusPins == 10){
            attempt2BonusPins = nextNextFrame.pinsKnockedDownAttempt1();
        } else {
            attempt2BonusPins = nextFrame.pinsKnockedDownAttempt2();
        }
        return attempt1BonusPins + attempt2BonusPins;
    }
}