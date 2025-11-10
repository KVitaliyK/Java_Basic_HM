package hm1;

import java.util.Random;
import java.util.Scanner;

public class hm1_1 {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int randomNumber = rand.nextInt(100);

        System.out.println("What is your name?");
        String name = sc.nextLine();

        System.out.println("Let the game begin!");
        while (true) {
            System.out.println("Enter your number");

            int playerNumber = sc.nextInt();

            if (playerNumber < randomNumber) {
                System.out.println("Your number is too small. Please, try again.");
            } else if (playerNumber > randomNumber) {
                System.out.println("Your number is too big. Please, try again.");
            } else {
                System.out.println("Congratulations, " + name + "!");
                break;
            }
        }
    }
}
