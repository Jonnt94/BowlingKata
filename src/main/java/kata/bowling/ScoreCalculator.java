package kata.bowling;

import kata.bowling.ScoreCard.ScoreCardBuilder;
import org.springframework.stereotype.Component;

import static kata.bowling.ScoreCard.ScoreCardBuilder.aScoreCard;

@Component
public class ScoreCalculator {
// Long term: build up calculate method into a scorecard class.
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

    public ScoreCard calculateScoreCard(Frames frames){
        int runningTotal = 0;
        ScoreCardBuilder scoreCardBuilder = aScoreCard();
        for (int i = 1; i <= 10; i++) {
            Frame frame = frames.getFrameAtPosition(i);
            int totalPinsKnockedDownInFrame = frame.totalPinsKnockedDown();
            runningTotal += totalPinsKnockedDownInFrame;
            if (frame.isStrikeOrSpare()) {
                runningTotal += getBonusScore(frames, frame, i);
            }
            scoreCardBuilder.appendWithFrameScore(new FrameScore(frame, runningTotal));
        }
        return scoreCardBuilder.build();
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