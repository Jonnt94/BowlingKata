package kata;

import java.util.List;

public class ScoreValidator {

    public boolean validate(List<Integer> scores) {

//    public boolean validate(List<Integer> scores) {
//        if(scores.size() >= 10 && scores.size() <= 20){
//            return true;
//        }
//
//        return false;
//    }
//    public boolean validate(List<Integer> scores) {
//        if(scores.contains(0)) {
//            return false;
//        }
//
//        return true;
//
//    }
//        public boolean validate(List<Integer> scores) {
//            if (scores.get(0) == 10 && scores.get(1) != 0) {
//                return false;
//            }
//
//            return true;
//        }
//    public boolean validate(List<Integer> scores) {
//    if (scores.get(0) == 10 && scores.get(1) == 0) {
//        return true;
//    }
//
//    return false;
//}
//    public boolean validate(List<Integer> scores){
//        if (scores.get(0) == -1){
//            return false;
//        }
//        return true;
//    }


        public boolean validate(List<Integer> scores){
            if (scores.contains(10)){
                return true;
            }
            return false;
        }
    }