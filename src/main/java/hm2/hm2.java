package hm2;

import java.util.Scanner;

public class hm2 {
    public static void main(String[] args) {
        String[][] schedule = new String[7][2];

        schedule[0][0] = "Sunday";
        schedule[0][1] = "do home work";
        schedule[1][0] = "Monday";
        schedule[1][1] = "go to courses; watch a film";
        schedule[2][0] = "Tuesday";
        schedule[2][1] = "attend meetings";
        schedule[3][0] = "Wednesday";
        schedule[3][1] = "write a report";
        schedule[4][0] = "Thursday";
        schedule[4][1] = "read a book";
        schedule[5][0] = "Friday";
        schedule[5][1] = "practice coding";
        schedule[6][0] = "Saturday";
        schedule[6][1] = "relax and have fun";


        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Enter number of days: ");
            String days = sc.nextLine();
            days = days.trim().toLowerCase();

            if(days.equals("exit")){
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            switch (days) {
                case "sunday":
                    printTask(schedule, "Sunday");
                    break;
                case "monday":
                    printTask(schedule, "Monday");
                    break;
                case "tuesday":
                    printTask(schedule, "Tuesday");
                    break;
                case "wednesday":
                    printTask(schedule, "Wednesday");
                    break;
                case "thursday":
                    printTask(schedule, "Thursday");
                    break;
                case "friday":
                    printTask(schedule, "Friday");
                    break;
                case "saturday":
                    printTask(schedule, "Saturday");
                    break;
                default:
                    System.out.println("Sorry, I don't understand you, please try again.");
            }
        }
    }
    private static void printTask(String[][] schedule, String day) {
        for (int i = 0; i < schedule.length; i++) {
            if (schedule[i][0].equalsIgnoreCase(day)) {
                System.out.println("Your tasks for " + schedule[i][0] + ": " + schedule[i][1] + ".");
                break;
            }
        }
    }
}
