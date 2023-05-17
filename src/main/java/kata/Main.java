package kata;

import kata.bowling.Frame;

public class Main {


    public static void main(String[] args) {
        Frame frame1 = new Frame();
        int gameTotal = frame1.FrameScore(10,2);

        Frame frame2 = new Frame();
        gameTotal += frame2.FrameScore(5,5);

        Frame frame3 = new Frame();
        gameTotal += frame3.FrameScore(9,4);

        System.out.println(gameTotal);
    }

}
