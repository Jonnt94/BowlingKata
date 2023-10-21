package kata;


import kata.bowling.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Main {


    public static void main(String[] args) {
        ScoreValidator scoreValidator = new ScoreValidator();
        FrameMapper frameMapper = new FrameMapper();
        FrameValidator frameValidator = new FrameValidator();
        ScoreCalculator scoreCalculator = new ScoreCalculator();
        ScoreBoard scoreBoard = new ScoreBoard(scoreValidator, frameMapper, frameValidator, scoreCalculator);

        Scanner bowlingScore = new Scanner(System.in);
        String attempt;
        List<Integer> scores = new ArrayList<>();

        do {
            System.out.print("Enter attempt: ");
            attempt = bowlingScore.next();
            if(!"Stop!".equals(attempt)) {
                scores.add(Integer.parseInt(attempt));
            }
        } while (!"Stop!".equals(attempt));

        System.out.println(scoreBoard.calculateDetailedScores(scores));

    }
}