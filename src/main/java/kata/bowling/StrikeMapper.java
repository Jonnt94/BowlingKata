package kata.bowling;

import java.util.ArrayList;
import java.util.List;

public class StrikeMapper {
    public static List<Integer> addSecondAttemptForStrikes(List<Integer> scores){
        List<Integer> scoresWithStrike = new ArrayList<>();

        for (Integer score : scores) {
            scoresWithStrike.add(score);

            if (score == 10) {
                scoresWithStrike.add(0);
            }
        }
        return scoresWithStrike;
    }
}
