package hm1;

import java.util.Random;
import java.util.Scanner;

public class hm1_2 {
    public static void main(String[] args) {
        char[][] board = new char[6][6];
        initializeBoard(board);

        Random random = new Random();
        int targetRow = random.nextInt(5) + 1;
        int targetCol = random.nextInt(5) + 1;

        System.out.println("All Set. Get ready to rumble!");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int row = 0, col = 0;

            while (true) {
                System.out.print("Enter line (1-5): ");
                if (scanner.hasNextInt()) {
                    row = scanner.nextInt();
                    if (row >= 1 && row <= 5) {
                        break;
                    } else {
                        System.out.println("Please enter a number between 1 and 5.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                }
            }


            while (true) {
                System.out.print("Enter column (1-5): ");
                if (scanner.hasNextInt()) {
                    col = scanner.nextInt();
                    if (col >= 1 && col <= 5) {
                        break;
                    } else {
                        System.out.println("Please enter a number between 1 and 5.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                }
            }

            if (row == targetRow && col == targetCol) {
                board[row][col] = 'x';
                printBoard(board);
                System.out.println("You have won!");
                break;
            } else {
                if (board[row][col] == '-') {
                    board[row][col] = '*';
                }
                printBoard(board);
            }
        }

        scanner.close();
    }

    private static void initializeBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == 0 && j == 0) {
                    System.out.print("  | ");
                } else if (i == 0) {
                    System.out.print(j + " | ");
                } else if (j == 0) {
                    System.out.print(i + " | ");
                } else {
                    System.out.print(board[i][j] + " | ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}