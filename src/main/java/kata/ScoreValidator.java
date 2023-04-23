package kata;

import java.util.List;

public class ScoreValidator {

    public boolean validate(List<Integer> scores) {
        if(scores.size() > 20){
            return false;
        }

        return true;
    }
}
