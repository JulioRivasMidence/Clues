package edu.miracosta.cs113;

import model.AssistantJack;
import model.Theory;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * JulioRivasClue.java the purpose of this driver class is to develop
 * a better investigation strategy. What I did insteaed of randomly
 * guessing is to generate new numbers based on the response of
 * the "Solutions" Variable and keeping track of the numbers I have already guessed before.
 *
 *  @author Julio Rivas
 *  @Version 1.0
 *
 */
public class JulioRivasClue {
    public static void main(String[] args) {
        // DECLARATION + INITIALIZATION
        int answerSet, solution = 0, murder = 0, weapon = 0, location = 0, murder2=0,weapon2=0,location2=0;
        Theory answer ;
        AssistantJack jack;
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();
        ArrayList<Integer> weaponG= new ArrayList<>();
        ArrayList<Integer> murderG= new ArrayList<>();
        ArrayList<Integer> locationG= new ArrayList<>();


        // INPUT
        System.out.print("Which theory would like you like to test? (1, 2, 3[random]): ");
        answerSet = keyboard.nextInt();
        keyboard.close();

        // PROCESSING
        jack = new AssistantJack(answerSet);

        do {
            solution = jack.checkAnswer(weapon, location, murder);
            if(solution ==1) {
                while(true){
                    weapon = random.nextInt(6) + 1;
                    if(weaponG.contains(weapon)){
                        continue;
                    }else{
                        weaponG.add(weapon);
                        break;
                    }
                }
            }
            if(solution ==2) {
                while(true){
                    location = random.nextInt(10) + 1;
                    if(locationG.contains(location)){
                        continue;
                    }else{
                        locationG.add(location);
                        break;
                    }
                }
            }
            if(solution == 3) {
                while(true){
                    murder = random.nextInt(6) + 1;
                    if(murderG.contains(murder)){
                        continue;
                    }else{
                        murderG.add(murder);
                        break;
                    }
                }
            }
        } while (solution != 0);

        answer = new Theory(weapon, location, murder);

        // OUTPUT
        System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution " + answer);

        if (jack.getTimesAsked() > 20) {
            System.out.println("FAILED!! You're a horrible Detective...");
        } else {
            System.out.println("WOW! You might as well be called Batman!");
        }

    }
}
