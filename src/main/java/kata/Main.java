package kata;


import kata.bowling.Frame;
import kata.bowling.FrameMapper;

import java.util.List;


public class Main {


    public static void main(String[] args) {
        List<Integer> scores = List.of(4,5,3,4,6,4,6,4,2,2,4,5,3,4,6,4,6,4,2,2);
//        validate scores.

        FrameMapper frameMapper = new FrameMapper();
        List<Frame> frames = frameMapper.map(scores);

    }

}
