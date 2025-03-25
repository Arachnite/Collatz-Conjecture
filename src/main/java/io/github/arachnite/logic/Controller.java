
package io.github.arachnite.logic;

import java.util.Scanner;

public class Controller {

    public static final String invalidMessage = "Invalid input. Please enter a valid number. ";

    public static void startAlgorithm() {

        try(Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter 1 for a single test case or 2 for a range of test cases: ");
            String input = sc.nextLine();

            while (true) {
                if (input.equals("1")) {
                    singleTest(sc);
                    break;
                } else if (input.equals("2")) {
                    rangeTest(sc);
                    break;
                } else {
                    System.out.print("1 or 2 only: ");
                }
            }

            System.out.print("\nDo you want to test again? (Y/N): ");
            input = sc.nextLine().toLowerCase();
            if(input.equals("y") || input.equals("yes")) {
                startAlgorithm();
            }
        }
    }

    public static void singleTest(Scanner sc) {

        System.out.print("Enter the number you want to test: ");
        while(true) {
            String input = sc.nextLine();
            try {
                long x = Long.parseLong(input);
                System.out.println("\nTest case: " + x);
                long i = x;
                while (i != 1) {
                    if (i % 2 == 0) {
                        i /= 2;
                    } else {
                        i = i * 3 + 1;
                    }
                    System.out.println(i);
                }
                System.out.println(x + " fulfills the Collatz Conjecture.");
                break;
            } catch (NumberFormatException e) {
                System.out.print(invalidMessage);
            }
        }
    }

    public static void rangeTest(Scanner sc) {

        long beginning;
        long ending;

        System.out.print("Enter the number you want to start with: ");
        while(true) {
            String input = sc.nextLine();
            try {
                beginning = Long.parseLong(input);
                break;
            } catch (NumberFormatException e) {
                System.out.print(invalidMessage);
            }
        }
        
        System.out.print("Enter the number you want to end with: ");
        while(true) {
            String input = sc.nextLine();
            try {
                ending = Long.parseLong(input);
                break;
            } catch (NumberFormatException e) {
                System.out.print(invalidMessage);
            }
        }
        
        System.out.println("\nTesting numbers from " + beginning + " to " + ending);
        for(long x = beginning; x <= ending; x++) {
            System.out.println("\nTest case: " + x);
            long i = x;
            while (i != 1) {
                if (i % 2 == 0) {
                    i /= 2;
                } else {
                    i = i * 3 + 1;
                }
                System.out.println(i);
            }
        }
        System.out.println("Numbers from " + beginning + " to " + ending + " fulfill the Collatz Conjecture.");
    }
}
