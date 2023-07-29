package kata.bowling;

import java.util.List;

public class ScoreCalculator {
// refactor this to use private methods.
    public int calculate(List<Frame> frames) {
        int runningTotal = 0;
        for (int i = 0; i < 10; i++) {
            Frame frame = frames.get(i);
            int totalPinsKnockedDownInFrame = frame.totalPinsKnockedDown();
            runningTotal += totalPinsKnockedDownInFrame;
            if (frame.isStrikeOrSpare()) {
                runningTotal += getBonusScore(frames, frame, i);
            }
        }
        return runningTotal;
    }

    private int getBonusScore(List<Frame> frames, Frame currentFrame, int i){
        Frame nextFrame = frames.get(i + 1);
        int bonusScore;
        if (currentFrame.isStrike()) {
            Frame nextNextFrame = frames.get(i + 2);
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