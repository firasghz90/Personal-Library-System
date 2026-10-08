import java.util.InputMismatchException;
import java.util.Scanner;

// A console-based Library Management System where a user can manage books, members, and borrowing/returning books
public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        String programName = "Personal Library";
        int totalBooks = 10;
        int totalMembers = 0;
        int borrowedBooks = 3;

        System.out.println("================================");
        System.out.println("    PERSONAL LIBRARY SYSTEM    ");
        System.out.println("================================");
        System.out.println();

        System.out.println("Welcome to the library!");
        System.out.print("What is your name? ");
        String userName = userInput.nextLine();
        System.out.println("Hello, " + userName + "!");
        System.out.println();

        System.out.println("Library: " + programName);

        boolean isRunning = true;
        while (isRunning) {
            int userChoice = getUserChoice(userInput);
            switch (userChoice) {
                case 1 -> {
                    displayLibraryInformation(totalBooks, totalMembers);
                    System.out.println("Press Enter to continue...");
                    userInput.nextLine();
                    userInput.nextLine();
                }
                case 2 -> {
                    checkAvailableBooks(totalBooks, borrowedBooks);
                    System.out.println("Press Enter to continue...");
                    userInput.nextLine();
                    userInput.nextLine();
                }
                case 3 -> {
                    System.out.println("Goodbye!");
                    isRunning = false;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    static int getUserChoice(Scanner userInput) {
        int userChoice = 0;
        boolean isValid = true;

        while (isValid) {
            try {
                System.out.println("================================");
                System.out.println("       LIBRARY MENU");
                System.out.println("================================");
                System.out.println("""
                        1. View Library Information
                        2. Check Available Books
                        3. Exit""");
                System.out.print("Choose an option: ");
                userChoice = userInput.nextInt();
                if (!(userChoice > 0 && userChoice < 4)) {
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
                    continue;
                }
                isValid = false;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                userInput.nextLine();
            }
        }
        return userChoice;
    }

    static void displayLibraryInformation(int totalBooks, int totalMembers) {
        System.out.println("You selected: View Library Information");
        System.out.println("Books: " + totalBooks);
        System.out.println("Members: " + totalMembers);
        System.out.println();

    }

    static void checkAvailableBooks(int totalBooks, int borrowedBooks) {
        System.out.println("You selected: Check Available Books");
        System.out.println("Borrowed: " + borrowedBooks);

        int availableBooks = totalBooks - borrowedBooks;
        System.out.println("Available: " + availableBooks);
        if (availableBooks > 0) {
            System.out.println("Books are available for borrowing.");
        } else {
            System.out.println("Sorry, no books are currently available.");
        }
        System.out.println();
    }
}
