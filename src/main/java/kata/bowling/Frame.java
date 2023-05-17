package kata.bowling;

public class Frame {
    int attempt1;
    int attempt2;

    public int FrameScore(int try1, int try2){
        attempt1 = try1;
        attempt2 = try2;

        if(attempt1 == 10){
            attempt2 = 0;
        }

        int frameTotal = attempt1 + attempt2;

        if (frameTotal > 10){
            frameTotal = 10;
        }

        return frameTotal;
    }
}