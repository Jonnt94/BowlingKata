package kata.bowling;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Collections.EMPTY_LIST;

public class Frames {

    private final List<Frame> framesList;

    public Frames(){
        this.framesList = EMPTY_LIST;
    }

    public Frames(List<Frame> framesList){
        this.framesList = framesList;
    }

    public int numberOfFrames(){
        return framesList.size();
    }

    public Frame getFrameAtPosition(int position){
        return framesList.get(position - 1);
    }

    public Frames append(Frame frameToAdd){
        List<Frame> newFramesList = Stream.concat(framesList.stream(),Stream.of(frameToAdd)).toList();
        return new Frames(newFramesList);
    }

    public List<Frame> asList() {
        return framesList;
    }
}
