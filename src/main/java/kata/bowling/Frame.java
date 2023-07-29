package kata.bowling;

public class Frame {
    private final int attempt1;
    private final int attempt2;

    private Frame(int attempt1, int attempt2) {
        this.attempt1 = attempt1;
        this.attempt2 = attempt2;

    }

    public static Frame of(int attempt1, int attempt2){
        return new Frame(attempt1, attempt2);
    }

    public int totalPinsKnockedDown(){
        return attempt1 + attempt2;
    }

    public int pinsKnockedDownAttempt1(){return attempt1;}

    public int pinsKnockedDownAttempt2(){return attempt2;}

    public boolean isStrike(){return attempt1 == 10;}

    public boolean isSpare(){return attempt1 + attempt2 == 10 && !isStrike();}

    public boolean isStrikeOrSpare(){return isStrike() || isSpare();}

    @Override
    public String toString() {
        return "Frame{" +
                "attempt1=" + attempt1 +
                ", attempt2=" + attempt2 +
                '}';
    }
}