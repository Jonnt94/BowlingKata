package kata.bowling;

import java.util.List;

public class ScoreValidator {

    public boolean validate(List<Integer> scores) {
        if (scores.size() < 10 || scores.size() > 20) {
            return false;
        }
        for(Integer score : scores) {
            if(score < 0 || score > 10){
                return false;
            }
        }
        return true;
    }
}