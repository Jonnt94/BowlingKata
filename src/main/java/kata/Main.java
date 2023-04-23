package kata;


import kata.bowling.ScoreBoard;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        ScoreBoard scoreBoard = new ScoreBoard();
        int score = scoreBoard.calculateScore(List.of(10,10,5));
        System.out.println(score);
    }
}
